import java.util.*;

public class CircularLinkly{
	
	static Node head; 
	
	static class Node{
		int val;
		Node next;
		public Node(int val) {
			this.val = val;
			next = null;
		}
		
	} 
	
	public static void insert(int n){
		Node node = new Node(n);
		if(head == null) {
			head = node;
			node.next = node;
			return;
		}
		
		
		Node temp = head;
		do {
			if(temp.next.val>n && head.val<n) {
				break;
			} 
			temp=temp.next;
			
		} while(temp.next!=head);
		
		node.next = temp.next;
		temp.next = node;
		if(head.val>n) {
			head = node;
		}
		
	}
	
	public static void print(){
		Node temp = head;
		do {
			System.out.print(temp.val+" ");
			temp = temp.next;
		}while(temp!=head);
	}
	
	public static void main(String[] args) {
		
		insert(1);
		insert(4);
		print();
		insert(3);
		insert(0);
		print();
	}
}