import java. util.*;

public class HorizontalDist{
	
	public static TreeMap<Integer, List<Integer>> lines = new TreeMap<>();
	public static TreeMap<Integer, Integer> node_hd = new TreeMap<>();
	public static TreeMap<Integer, Integer> unique_hd = new TreeMap<>();
	public static Queue<Node> top_view = new LinkedList<>();
	
	static class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	public static void calc_dist(Node root) {
		calc_distUtil(root, 0);
		
	}
	
	
	public static void calc_distUtil(Node n, int hd) {
		if(n == null) {
			return;
		}
		if(!lines.containsKey(hd)) {
			List<Integer> first_node = new LinkedList<>();
			first_node.add(n.data);
			lines.put(hd, first_node);
			node_hd.put(n.data,hd);
		} else {
			LinkedList<Integer> l = (LinkedList<Integer>)lines.get(hd);
			l.add(n.data);
			lines.put(hd, l);
			node_hd.put(n.data,hd);
		}
		
		calc_distUtil(n.left, hd-1);
		calc_distUtil(n.right, hd+1);
		
	}
	
	
	public static void main(String args[]) {
		
		Node root = new Node(1);
        root.left  = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        calc_dist(root);
		
		System.out.println("Vertical Lines are:");
		for(Integer i: lines.keySet()) {
			LinkedList<Integer> nodes = (LinkedList<Integer>)lines.get(i);
			System.out.print("Key:"+i+" Nodes are:");
			for(Integer j: nodes){
				System.out.print(j+" ");
				System.out.println();
			}
		}
		
		System.out.println("Top View:");
		////////////////////////////// PRINT TOP VIEW////////////////////////////////
		get_topView(root);
		for(Integer i: unique_hd.keySet()) {
			System.out.print(unique_hd.get(i)+" ");
			
		}
			
	}
	
	
	public static void get_topView(Node root){
		
		top_view.add(root);
		
		while(!top_view.isEmpty()) {
			Node n = top_view.remove();
			//System.out.println("here");
			//System.out.println(n.data+" in loop data");
			if(!unique_hd.containsKey(node_hd.get(n.data))) {
				unique_hd.put(node_hd.get(n.data), n.data);
				if(n.left!=null) {
					top_view.add(n.left);
				}
				if(n.right != null) {
					top_view.add(n.right);
				}
			}
		}
		
		
	}
	
	public Queue<Node> l_order = new LinkedList<>();
    void levelOrder(Node root) {
       
		l_order.add(root);
		while(!l_order.isEmpty()) {
			Node n = l_order.remove();
			System.out.print(n.data+" ");
			if(n.left!=null){
				l_order.add(n.left);
			} 
			if(n.right!=null) {
				l_order.add(n.right);
			}
		}
    }

}