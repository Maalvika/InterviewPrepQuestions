import java.util.*;

// Question 1
public class RemoveDups{
	
	static class Node{
		int val;
		Node next;
		public Node(int v){
			val = v;
			next = null;
		}
	}
	
	public static void main(String[] args) {
		
		Node head = new Node(0);
		head.next = new Node(1);
		head.next.next = new Node(2);
		head.next.next.next = new Node(1);
		head.next.next.next.next = new Node(0);
		//head.next.next.next.next.next = new Node(0);
		Node node = way_one(head);
		System.out.println("WAY ONE:");
		while(node!=null) {
			System.out.print(node.val+" ");
			node = node.next;
			
		}
		//System.out.println("End way one");
		node = way_two(head);
		System.out.println("\n WAY TWO:");
		while(node!=null) {
			System.out.print(node.val+" ");
			node = node.next;
		}
		
	}
	
	//Method 1
	public static Node way_one(Node h) {
		List<Integer> li = new LinkedList<>();
		Node prev = h;
		Node temp = h.next;
		li.add(h.val);
		while(temp!=null) {
			//System.out.println("Prev way one:"+prev.val);
			//System.out.println("Node way one:"+temp.val);
			if(li.contains(temp.val)) {
				//System.out.println("Removing:"+temp.val);
				prev.next = temp.next; 
			} else {
				li.add(temp.val);
				prev = temp;
			}
			temp = temp.next;
		}
		
		return h;
	}
	
	//Runner Method: Keep removing duplicate occurances
	public static Node way_two(Node h) {
		Node temp = h;
		Node remover = null;
		while(temp!=null){
			remover = temp.next;
			while(remover!=null) {
				if(remover.val == temp.val) {
					remover.next = temp.next;
				}
				remover = remover.next;
			}
			temp = temp.next;
			
		}
		return h;
	}
}