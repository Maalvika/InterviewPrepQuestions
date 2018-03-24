import java.util.*;

public class DiameterOfTree {
	
	Node root;
	
	static class Node{
		int val;
		Node left, right;
		
		public Node(int val){
			this.val = val;
			left = right = null;
		}
	}
	
	public int diameter(Node n){
		if(n == null) {
			return 0;
		}
		
		int lh = getHeight(n.left);
		int rh = getHeight(n.right);
		
		int ldim = diameter(n.left);
		int rdim = diameter(n.right);
		
		return Math.max((lh+rh+1), Math.max(ldim,rdim));
	} 
	
	public int getHeight(Node n){
		if(n == null) {
			return 0;
		} else {
			return Math.max(getHeight(n.left), getHeight(n.right))+1;
		}
	}
	
	public static void main(String[] args) {
		
		DiameterOfTree dm = new DiameterOfTree();
		dm.root = new Node(1);
		dm.root.left = new Node(2);
		dm.root.right = new Node(3);
		dm.root.left.left = new Node(2);
		dm.root.left.right = new Node(2);
		dm.root.left.right.right = new Node(2);
		dm.root.left.right.right.right = new Node(2);
		dm.root.left.left.left = new Node(2);
		dm.root.left.left.left.left = new Node(2);
		
		System.out.println("DiameterOfTree:"+dm.diameter(dm.root));
		
	}
	
}