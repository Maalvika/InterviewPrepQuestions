import java.util.*;

class Node{
	int data;
	Node left, right;
	
	public Node(int data){
		this.data = data;
		
	}
	
}

public class TreeBST {
	
	Node root;
	
	public TreeBST(Node r) {
		this.root = r;
	}
	
	public TreeBST() {
		this.root = null;
	}
	////////////////////// Chapter 4 Question 2/////////////////////////////////
	public static Node createMinBST(int[] arr, int start, int end){
		if(start>end) {
			return null; 
		} else {
			int mid = (start + end)/2;
			Node n = new Node(arr[mid]);
			n.left = createMinBST(arr, start, mid-1);
			n.right = createMinBST(arr, mid +1, end);
			return n;
		}
	}
	////////////////////// Chapter 4 Question 2 END /////////////////////////////////
	
	////////////////////// Chapter 4 Question 3 /////////////////////////////////
	
	//LevelOrder is usually O(n^2) with recursive approach. But having O(n) space complexity with the
	//algorithm below O(n) bounds can be achieved.
	public void list_of_depth(Node root, ArrayList<LinkedList<Integer>> depths, int level){
		LinkedList<Integer> l = null;
		if(depths.size() == level) {
			l  = new LinkedList<>();
			depths.add(l);
		} else {
			l = depths.get(level);
		}
		if(root ==null){
			return;
		}
		l.add(root.data);
		// If you want to sort the values in each level
		//Collections.sort(l);
		list_of_depth(root.left, depths, level+1);
		list_of_depth(root.right, depths, level+1);
		
	}
	
	////////////////////// Chapter 4 Question 3 END /////////////////////////////////
	
	////////////////////// Chapter 4 Question 4 /////////////////////////////////
	
	public boolean isBalanced(){
		int score = postOrderBalancedTest(this.root);
		if(score>0){
			return true;
		}
		return false;
	}
	
	public int postOrderBalancedTest(Node root){
		
		int lst = findDepth(root.left);
		// check if left subtree is imbalance return
		if(lst==-1) {
			return -1;
		}
		int rst = findDepth(root.right);
		if(rst == -1) {
			return -1;
		}
		int score = lst - rst;
		if(Math.abs(score)>1) {
			return -1;
		}
		return Math.max(lst,rst)+1;
		
	}
	
	////////////////////// Chapter 4 Question 4 END /////////////////////////////////
	
	public int findDepth(Node root){
		if(root == null) {
			return 0;
		} else {
			return Math.max(findDepth(root.left), findDepth(root.right)) +1;
		}
	}
	
	public boolean isBST(Node root, int min, int max){
		if(root == null) {
			return true;
		}
		if(root.left != null && root.data < root.left.data) {
			return false;
		} 
		if(root.right != null && root.data > root.right.data) {
			return false;
		} 
		
		if(root.data <min || root.data>max) {
			return false;
		}
		return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
		
	}
	
	public int ksmallelem(int k){
		Stack<Node> s = new Stack<>();
		int cnt =0;
		
		// smallest element will be in the left
		Node temp = this.root;
		while(temp!=null){
			s.push(temp);
			temp = temp.left;
			
		}
		// if we pop a node then we check its right subtree and push it on stack
		Node top = s.pop();
		while(top!=null) {
			cnt++;
			if(cnt == k){
				return top.data;
			}
			top = top.right;
			while(top!=null) {
				s.push(top);
				top = top.left;
			}
			// top will be null: assign to stack's head
			top = s.pop();
		}
		return -1;
		
	} 
	
	public Node findNode(Node root, int value) {
		
		if(root.data == value) {
			return root;
		}
		if(value > root.data) {
			return findNode(root.right, value);
		} else {
			return findNode(root.left, value);		
		}
		
	}
	
	// Question 8: common ancestor
	public Node findCommonAncestor(Node root, Node n1, Node n2){
		
		LinkedList<Node> anc_n1 = getAncestorList(new LinkedList<Node>(), root, n1);
		LinkedList<Node> anc_n2 = getAncestorList(new LinkedList<Node>(), root, n2);
		Node lca = root;
		int i=0;
		while ((anc_n1!= null || anc_n2!=null ) && anc_n1.get(i).data == anc_n2.get(i).data) {
			lca = anc_n1.get(i);
			i++;
		}
		return lca;
		
	}
	
	public LinkedList<Node> getAncestorList(LinkedList<Node> ancestor, Node root, Node n){
		if(n.data == root.data) {
			ancestor.add(root);
			//System.out.println("equal");
			return ancestor;
			
			
		}
		if(n.data > root.data) {
			ancestor.add(root);
			//System.out.println("greater");
			return getAncestorList(ancestor, root.right, n);
		} else {
			ancestor.add(root);
			//System.out.println("lesser");
			return getAncestorList(ancestor, root.left, n);
		}
		
	}
	
	public static void main(String[] args) {
		int[] vals = {2,4,6,8,10,16,27};
		Node root = createMinBST(vals, 0, vals.length-1);
		TreeBST t = new TreeBST(root);
		System.out.println("Depth:"+t.findDepth(root));
		ArrayList<LinkedList<Integer>> depth =  new ArrayList<>();
		t.list_of_depth(root, depth, 0);
		System.out.println("\nLevel order in O(n)");
		for(LinkedList<Integer> l: depth) {
			for(int i: l){
				System.out.print(i+" ");
			}
			System.out.println();
		}
		System.out.println("is Balances?!:"+t.isBalanced());
		System.out.println("\nis BST?!:"+t.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
		int k=6;
		System.out.println("The "+k+" smallest element is :"+t.ksmallelem(k));
		Node n1 = t.findNode(root, 2);
		//System.out.println("node 1:"+n1.data);
		Node n2 = t.findNode(root, 27);
		//System.out.println("node 2:"+n2.data);
		System.out.println("LCA :"+t.findCommonAncestor(root,n1, n2).data);
		
		
	}
}