import java.util.*;

public class MakeTree {
	
	public static ArrayList<Node> tree;
	
	static class Node {
		public int left;
		public int right;
		public int parent;
		
		public Node(int p, int l, int r) {
			parent = p;
			//this.rank = rank;
			left = l;
			right = r;
		}
		
		
		
	}
	
	public static void union_op(Node s, Node d){
		Node s_r = find_root(s);
		Node d_r = find_root(d);
		d.parent = tree.indexOf(s);
		if(tree.indexOf(s_r) <= tree.indexOf(d_r)) {
				s.left = tree.indexOf(d);
			} else {
				s.right = tree.indexOf(d);
		}
	}
	
	public static Node find_root(Node u){
		if(tree.indexOf(u) == u.parent) {
			return u;
		}
		return find_root(tree.get(u.parent));
	}
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of nodes:");
		int n = scan.nextInt();
		System.out.println("Enter number of edges:");
		int p = scan.nextInt();
		tree = new ArrayList<>();
		for(int i=0; i<n; i++) {
			Node temp = new Node(i,i, i);
			tree.add(temp);
		}
		System.out.println("Specify edges:");
		for(int i=0; i<p; ++i) {
			 int s = scan.nextInt();
			 int d = scan.nextInt();
			 union_op(tree.get(s), tree.get(d));
		}
		for(int i=0; i<n; i++) {
			Node temp = tree.get(i);
			System.out.println("For Node: "+i+" Parent: "+temp.parent+" left: "+temp.left+" right: "+temp.right);
			
		}
		
	}
}