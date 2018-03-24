import java.util.*;

public class NumBST {
	
	static class Node{
		int data;
		Node left, right;
		public Node(int data) {
			this.data =data;
			left = right = null;
		}
	}
	
	public static int[] memo;
	
	public static int countBST(int n){
		memo[0]=1;
		memo[1]=1;
		for (int i=2; i<=n; i++) {
			memo[i] =0;
			for(int j=0;j<i; j++) {
				memo[i] += memo[j]*memo[i-j-1];
			}
		}
		return memo[n];
	}
	
	public static List<Node> BST_combi(int s, int e){
		
		List<Node> combo = new LinkedList<>();
		if(s>e) {
			combo.add(null);
			return combo;
		}
		
		for(int i=s; i<=e; i++) {
			List<Node> left = BST_combi(s, i-1);
			List<Node> right = BST_combi(i+1, e);
			for(int j=0; j<left.size(); j++) {
				Node l = left.get(j);
				for(int k=0; k<right.size();k++){
					Node r = right.get(k);
					Node n = new Node(i);
					n.left = l;
					n.right = r;
					combo.add(n);
				}
			}
		}
		return combo;
	}
	
	public static void print_preorder(Node root) {
		
		if(root == null) {
			return;
		}
		System.out.print(root.data+" ");
		print_preorder(root.left);
		print_preorder(root.right);
	}
	
	
	
	public static void main(String[] args) {
		List<Node> bst = BST_combi(1,3);
		for(Node n: bst) {
			//System.out.println("here:"+n.data);
			print_preorder(n);
			System.out.println();
		}
		int n = 3;
		memo = new int[n+1];
		int number  = countBST(n);
		System.out.println("Possible BST:"+number);
	}
}