import java.util.*;

// Also refered to as Level Order Travrsal
public class TreeBFS {
	
	Node root;
	Queue<Node> queue = new LinkedList<>();
	
	public TreeBFS(){
		
		Node root = new Node(9);
		root.left = new Node(8);
		root.right = new Node(7);
		root.left.left = new Node(6);
		root.left.right = new Node(5);
		root.right.left = new Node(4);
		root.right.right = new Node(3);
		
		this.root = root;
	}
	
	class Node {
		
		Node left;
		Node right;
		int data;
		
		public Node(int data) {
			this.data = data;
			left = right = null;
			
		}
	}
	
	public List<Integer> run_BFS(){
		List<Integer> data_list = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()){
			Node n = queue.remove();
			data_list.add(n.data);
			if(n.left != null) {
				queue.add(n.left);
			}
			if(n.right!= null) {
				queue.add(n.right);
			}
		}
		
		return data_list;
	}
	
	public static void main(String[] args) {
		
		TreeBFS tree = new TreeBFS();
		
		List<Integer> elem = tree.run_BFS();
		
		for(Integer i: elem) {
			System.out.print(i+" ");
		}
		
	}
}