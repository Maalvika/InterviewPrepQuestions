import java.util.*;

public class MirrorTree {
	
	Node root;
	
	static class Node{
		int val;
		Node left, right;
		public Node(int val) {
			this.val = val;
			left = right = null;
		}
	}
	
	public static Node createMirror(Node n) {
		if(n==null) {
			return null;
		}
		createMirror(n.left);
		createMirror(n.right);
		Node temp = n.left;
		n.left = n.right;
		n.right = temp;
		return n;
	}
	
	public static void inorder(Node n) {
		if(n==null) {
			return;
		}
		inorder(n.left);
		System.out.print(n.val+" ");
		inorder(n.right);
	}
	
	public static void main(String[] args) {
		Node n = new Node(1);
		n.left = new Node(2);
		n.right = new Node(3);
		n.left.left = new Node(4);
		n.left.right = new Node(5);
		n.right.left = new Node(6);
		n.right.right = new Node(7);
		inorder(n);
		System.out.println();
		Node r = createMirror(n);
		inorder(r);
		
	}
}