import java.util.*;

public class SwapNode {
	
	
	class Node {
		int data;
		Node l;
		Node r;
		
		public Node(int data) {
			this.data = data;
			l = r = null;
		}
		
		
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Node[] ptr = new Node[n + 1];
		for(int i=1; i<=n; i++) {
			
			Node l = new Node(scan.nextInt());
			Node r = new Node(scan.nextInt()); 
			Node p = new Node(i);
			p.l = l;
			p.r = r;
			ptr[i] = p;
			ptr[l.data] = l;
			ptr[r.data] = r;
			
		}
		
	}
}