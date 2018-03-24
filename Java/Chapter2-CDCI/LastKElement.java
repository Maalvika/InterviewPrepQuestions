import java.util.*;

public class LastKElement {
	static class Node {
		int data;
		Node next;
		public Node(int val) {
			data = val;
			next = null;
		}
	} 
	public static void main(String[] args){
		Node head = new Node(0);
		head.next = new Node(1);
		head.next.next = new Node(2);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		Node res = findKfromLast(head, 4);
		System.out.println("value:"+res.data);
	}
	
	public static Node findKfromLast(Node head, int k) {
		Node slow, fast;
		slow = fast = head;
		while(k>0){
			fast = fast.next;
			k--;
		}
		while(fast!=null) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}