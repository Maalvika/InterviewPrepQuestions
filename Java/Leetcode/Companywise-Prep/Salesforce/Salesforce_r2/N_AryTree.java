import java.util.*;

public class N_AryTree {
	
	static class Node{
		int key;
		List<Node> child;
		
		public Node(int key) {
			this.key = key;
			child = new LinkedList<>();
		}
	}
	Node root = null;
	
	public void BFS_util(){
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			Node curr = q.poll();
			System.out.println("Parent:"+curr.key);
			for(Node n:curr.child) {
				if(n!=null) {
					q.offer(n);
					System.out.print(n.key+" ");
				}
				
			}
			System.out.println();
		}
	}
	
	public void level_order(Node n, ArrayList<LinkedList<Integer>> lod, int level) {
		LinkedList<Integer> l; 
		if(lod.size() == level) {
			l = new LinkedList<Integer>();
			lod.add(l);
		} else {
			l = lod.get(level);
		}
		if(n == null) {
			return;
		}
		l.add(n.key);
		for(Node c:n.child) {
			level_order(c, lod, level+1);
		}
	}
	
	
	public static void main(String[] args) {
		N_AryTree nt = new N_AryTree();
		Node n = new Node(1);
		for(int i=2; i<=10; i++) {
			Node t = new Node(i);
			for(int j = i*2; j<15; j+=1) {
				Node x = new Node(j);
				t.child.add(x);
			}
			n.child.add(t);
		}
		
		nt.root = n;
		nt.BFS_util();
		
		ArrayList<LinkedList<Integer>> lod = new ArrayList<>();
		nt.level_order(nt.root, lod, 0);
		int k=1;
		for(LinkedList<Integer> i: lod) {
			System.out.println("\nFor level "+k);
			for(Integer j:i) {
				System.out.print(j+ " ");
			}
			k++;
		}
		
	}
}