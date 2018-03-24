import java.util.*;

/**
* This solution has just the implementation for union find. 
* Palindrome hasnt been implemented yet.
*/

class Solution_UnionFind {
	
	static class Node {
		public int parent;
		public int rank;
		
		public Node(int p, int r) {
			parent = p;
			rank = r;
		}
		
		
		
	}
	
	public static void union_op(Node s, Node d){
		Node s_r = find_root(s);
		Node d_r = find_root(d);
		if (s_r.rank > d_r.rank) {
			d_r.parent = s_r.parent;
		} else {
			s_r.parent = d_r.parent;
			if(s_r.rank == d_r.rank) {
				d_r.rank++;
			}
			
		}
	}
	
	public static int find_root(Node u){
		if(u.parent != tree.indexOf(u)) {
			u.parent = find_root(u.parent);
		}
		return tree.get((int)u.parent);
	}
	
	public static ArrayList<Node> tree;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int p = scan.nextInt();
		tree = new ArrayList<>();
		for(int i=0; i<n; i++) {
			Node temp = new Node(i,0);
			tree.add(temp);
		}
		for(int i=0; i<p; ++i) {
			 int s = scan.nextInt();
			 int d = scan.nextInt();
			 union_op(tree.get(s), tree.get(d));
		}
		
		for(int i=0; i<n; i++) {
			Node temp = tree.get(i);
			System.out.println("Node:"+i+" Parent:"+temp.parent+" Rank:"+temp.rank);
			
		}
		
		
	}
}