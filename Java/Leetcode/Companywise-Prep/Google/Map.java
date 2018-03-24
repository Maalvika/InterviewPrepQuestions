import java.util.*;

class HashNode<K,T>{
	K key;
	T value;
	HashNode<K, T> next;
	
	public HashNode(K key, T value) {
		this.key = key;
		this.value = value;
		next = null;
	}
}
public class Map<K, T> {
	private int bucket_size;
	private double load;
	private int size;
	
	private ArrayList<HashNode<K,T>> buckets;
	
	public Map(){
		bucket_size = 10;
		load = 0.7f;
		size = 0;
		buckets = new ArrayList<>();
		for(int i=0; i<bucket_size; i++) {
			buckets.add(null);
		}
	}
	
	public Map(int init_size, double load){
		bucket_size = init_size;
		this.load = load;
		size = 0;
		buckets = new ArrayList<>();
		for(int i=0; i<bucket_size; i++) {
			buckets.add(null);
		}
	}
	
	private int get_bucketID(K key){
		int hash_code = key.hashCode();
		return hash_code%bucket_size;
		
	}
	
	public void add(K key, T value) {
		int index = get_bucketID(key);
		
		HashNode<K,T> head = buckets.get(index);
		HashNode<K,T> newValue = new HashNode<K, T>(key, value);
		if(head == null) {
			buckets.set(index, newValue);
			return;
		}
		while(head.next!=null) {
			if(head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		size++;
		
		newValue.next = buckets.get(index);
		buckets.set(index, newValue);
		
		//Handle when load factor value has reached: re-size it
		if((1.0 * size)/bucket_size >= load) {
			ArrayList<HashNode<K,T>> temp = buckets;
			buckets = new ArrayList<>();
			bucket_size = bucket_size * 2;
			size = 0;
			for(int i=0; i<bucket_size; i++) {
				buckets.add(null);
			}
			for(HashNode<K,T> n:temp) {
				while(n!=null) {
					add(n.key, n.value);
					n = n.next;
				}
			}
			
		}
		
	}
	
	public void remove(K key) {
		int index = get_bucketID(key);
		HashNode<K,T> head = buckets.get(index);
		HashNode<K,T> prev = null;
		if(head.key.equals(key)) {
			buckets.set(index, head.next);
			return;
		}
		while(head!=null) {
			if(head.key.equals(key)) {
				break;
			}
			prev = head;
			head = head.next;
		}
		
		if(head == null) {
			return;
		}
		size--;
		prev.next = head.next;
		return;
		
	}
	
	public T get(K key) {
		int index = get_bucketID(key);
		HashNode<K,T> head = buckets.get(index);
		
		while(head!=null) {
			if(head.key.equals(key)) {
				return  head.value;
			}
			head = head.next;
		}
		
		return null;
		
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public static void main(String[] args){
		Map<Integer, String> map = new Map<>(3, 0.5);
		map.add(1,"a");
		map.add(2,"b");
		System.out.println("map get "+map.get(1));
		System.out.println("map get "+map.get(2));
		map.add(3,"c");
		System.out.println("map get "+map.get(2));
		map.remove(1);
		System.out.println("map get "+map.get(1));
		System.out.println("map get "+map.get(3));
	}
	
}