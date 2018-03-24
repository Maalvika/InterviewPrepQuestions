import java.util.*;

class LRUCache {
    
    class Node{
        int key;
        int value;
        Node next;
        Node prev;
        
        public Node(int k, int v){
            key = k;
            value = v;
            next = null;
            prev = null;
        }
    }
    HashMap<Integer, Node> map;
    Node head, tail;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        map = new HashMap<>();
        head = tail = null;
    }
    
    public int get(int key) {
        System.out.println("get:"+key);
        Node n = map.get(key);
        if(n!=null){
            refresh(n);
            return n.value;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        System.out.println("put:"+key);
        Node n = map.get(key);
        if(n!=null){
            n.value = value;
            refresh(n);
        } else {
            n = new Node(key, value);
            add_node(n);
        }
        
    }
    
    public void refresh(Node n){
        remove_node(n);
        add_node(n);
    }
    
    public void remove_node(Node n) {
        if(size == 0) {
            return;
        }
        if(size == 1) {
            head = tail = null;
        } else if(head == n) {
            //System.out.println("same head and tail");
            head = head.next;
            head.prev = null;
            n.next = null;
        } else if(tail == n) {
            tail = tail.prev;
            tail.next = null;
            n.prev = null;
        } else {
            n.prev.next = n.next;
            n.next.prev = n.prev;
            n.next = null;
            n.prev = null;
        }
        
        map.remove(n.key);
        size--;
        
    }
    
    public void add_node(Node n) {
        if(size == capacity) {
            remove_node(tail);
        }
        if(head == null && tail == null) {
            head = tail = n;
        } else {
       // System.out.println("adding element");
            head.prev = n;
            n.next = head;
            head = n;
        }
        map.put(n.key, n);
        size++;
    }
        
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */