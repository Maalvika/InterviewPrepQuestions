import java.util.*;

public class MaxPathBT {
	
	static class Node{
		int data;
		Node left, right;
		
		public Node(int data){
			this.data = data;
			left = right = null;
		}
	}
	
	
	public static int find_maxPath(Node n){
		return find_maxPath_helper(n, Integer.MIN_VALUE);
	}
	
	public static int find_maxPath_helper(Node n, int res){
		if(n==null) {
			return 0;
		}
		
		int lpath = find_maxPath_helper(n.left, res);
		int rpath = find_maxPath_helper(n.right, res);
		
		int node_path = Math.max(Math.max(lpath,rpath) + n.data, n.data);
		
		int curr = Math.max(lpath+rpath+n.data,  node_path);
		
		res = Math.max(curr,res);
		
		return res;
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(10);
		root.left = new Node(2);
		root.right = new Node(-25);
		root.left.right = new Node(-2);
		root.left.left = new Node(10);
		
		System.out.println("Max path:"+ find_maxPath(root));
	}
}