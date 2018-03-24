import java.util.*;

public class MaxPathLeaf {
	
	static class Node {
		int val;
		Node left, right;
		
		public Node(int val) {
			this.val = val;
			left = right = null;
		}
	}
	
	static class Res {
		public int val;
	}
	Node root;
	
	
	public int max_path_to_root(Node n){
		if(n == null) {
			return 0;
		}
		return Math.max(n.val + max_path_to_root(n.left), n.val + max_path_to_root(n.right));
	}
	
	public int max_path_BT(Node n, Res res){
		if(n == null) {
			return 0;
		}
		int lpath = max_path_BT(n.left, res);
		int rpath = max_path_BT(n.right, res);
		
		int node_path = Math.max(Math.max(lpath,rpath)+n.val, n.val);

		int curr = Math.max(lpath+rpath+n.val, node_path);
		
		res.val = Math.max(res.val, curr);
		
		return node_path;
	}
	
	public static void main(String[] args) {
		MaxPathLeaf tree = new MaxPathLeaf();
		
        tree.root = new Node(10);
        tree.root.left = new Node(-2);
        tree.root.right = new Node(7);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(-4);
        
		System.out.println("Max path to root: "+tree.max_path_to_root(tree.root));
		Res res = new Res();
        res.val = Integer.MIN_VALUE;
		tree.max_path_BT(tree.root, res);
		System.out.println("Max path overall: "+res.val);
	}
}