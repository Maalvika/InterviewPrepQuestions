import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {
	
	public static ArrayList<Node> components;
    
    static class Node {
        
        public int rank;
        public int parent;
		public int nodes;
        
        public Node(int p, int r){
            parent = p;
            rank = r;
			nodes = 1;
        }
    }
	
	public static void union_op(Node s, Node d){
		Node s_r = find_root(s);
		Node d_r = find_root(d);
		if (s_r.rank > d_r.rank) {
			d_r.parent = s_r.parent;
			s_r.nodes += d_r.nodes;
		} else {
			if(s_r != d_r) {
				d_r.nodes += s_r.nodes;
			}
			s_r.parent = d_r.parent;
			if(s_r.rank == d_r.rank) {
				d_r.rank++;
			}
			
		}
	}
	
	public static Node find_root(Node u){
		if(u.parent != components.indexOf(u)) {
			u.parent = components.indexOf(find_root(components.get(u.parent)));
		}
		return components.get((int)u.parent);
	}

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
		int p = scan.nextInt();
		
		components = new ArrayList<>();
		for(int i=0; i<n; i++) {
			components.add(new Node(i, 0));
		}
		
		for(int i=0; i<p; i++) {
			int s = scan.nextInt();
			int d = scan.nextInt();
			union_op(components.get(d), components.get(s));
			
		}
		
		BigInteger num = BigInteger.valueOf(n);
		BigInteger num_1 = BigInteger.valueOf(n-1);
		BigInteger total = num.multiply(num_1).divide(BigInteger.valueOf(2));
		
		for(int i=0; i<n; i++) {
			if(i == components.get(i).parent) {
				BigInteger temp = BigInteger.valueOf(components.get(i).nodes);
				BigInteger temp_1 = BigInteger.valueOf(components.get(i).nodes-1);
				BigInteger temp_prod = temp.multiply(temp_1).divide(BigInteger.valueOf(2));
				total = total.subtract(temp_prod);
			}
		}
		
		System.out.println(total);
		
    }
}