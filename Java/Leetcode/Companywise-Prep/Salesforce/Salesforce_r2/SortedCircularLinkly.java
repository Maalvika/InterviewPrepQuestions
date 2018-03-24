import java.util.*;

public class SortedCircularLinkly {
	
	class Node {
		int val;
		Node next;
		
		public Node(int val) {
			this.val = val;
			next = null;
		}
	}
	Node head = null;
	//To do: insert a node in a sorted circular linked list
	public void insertNode(int val) {
		Node n = new Node(val);
		
		if(head == null) {
			head = n;
			n.next = head;
			return;
		}
		System.out.println("Inserting! Current head is:"+head.val);
		// Find the correct position of new node
		Node temp = head;
		while(temp.next!=head) {
			if(temp.next.val>n.val && head.val<n.val) {
				break;
			}
			temp = temp.next;
		}
		
		n.next = temp.next;
		temp.next = n;
		if(n.val<head.val) {
			head = n;
		}
	}
	
	public void print_sortedVal(){
		System.out.println("\nPrinting:");
		Node i = head;
		do {
			System.out.print(i.val+" ");
			i=i.next;
		} while(i!=head);
	}
	
	public static void main(String[] args){
		SortedCircularLinkly sc = new SortedCircularLinkly();
		sc.insertNode(5);
		sc.insertNode(9);
		sc.print_sortedVal();
		sc.insertNode(7);
		sc.print_sortedVal();
		sc.insertNode(3);
		sc.print_sortedVal();
		sc.insertNode(1);
		sc.insertNode(32);
		sc.insertNode(79);
		sc.insertNode(2);
		sc.print_sortedVal();
	}
}