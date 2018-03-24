import java.util.*;

class Node{
	int val;
	Node left,right;
	
	public Node(int val) {
		this.val = val;
		left = right =null;
	}
}
public class DiameterOfTree {
	Node root;
	
	public int get_diameter(Node n){
		if(n==null){
			return 0;
		} 
		int lh = get_height(n.left);
		int rh = get_height(n.right);
		
		int ld = get_diameter(n.left);
		int rd = get_diameter(n.right);
		
		return Math.max(lh+rh+1, Math.max(ld, rd));
	}
	
	public int get_height(Node n){
		if(n==null) {
			return 0;
		}
		return Math.max(get_height(n.left), get_height(n.right))+1;
	}
	
	
	public static void main(String[] args) {
		
		DiameterOfTree tree = new DiameterOfTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
		
		System.out.println("Diameter is:"+tree.get_diameter(tree.root));
	}
}