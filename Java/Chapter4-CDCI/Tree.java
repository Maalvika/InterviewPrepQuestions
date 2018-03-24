import java.util.*;

// Creating a simple data structure of a Node in the Tree
// Tree consist of  multiple nodes. Each node has a left and right child and data that it holds.
class Node{
	int data;
	Node left, right;
	
	public Node(int data){
		this.data = data;
		
	}
	
}

/**
Create a simple data structure for Tree. It contains the pointer to the root of the tree.
*/
public class Tree {
	
	Node root;
	
	public Tree(Node r) {
		this.root = r;
	}
	
	public Tree() {
		this.root = null;
	}
	/////////////////////////// CREATE A BINARY SEARCH TREE FROM SORTED ARRAY ////////////////////////////////
	
	/**
	* It recursively creates a binary search tree using binary search algorithm. 
	* The complexity of this is O(logn)/
	*/
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
	/////////////////////////// LEVEL ORDER TRAVERSAL ////////////////////////////////
	
	/**
	*LevelOrder is usually O(n^2) with recursive approach. But having O(n) space complexity with the
	*algorithm below O(n) bounds can be achieved.
	*/
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
		list_of_depth(root.left, depths, level+1);
		list_of_depth(root.right, depths, level+1);
		
	}
	
	/////////////////////////// CHECK IF THE BINARY TREE IS BALANCED OR NOT ////////////////////////////////
	
	/**
	* Post-order evaluation strategy is used. In post-order, the order of visiting the nodes is Left, Right, Root. 
	* Hence, we evaluate recursively, if left is balanced or not, then if right is balanced or not, based on the 
	* balanced score of left and right, score for root is evaluated. 
	*/
	public boolean isBalanced(){
		int score = postOrderBalanced_Utils(this.root);
		if(score>0){
			return true;
		}
		return false;
	}
	
	public int postOrderBalanced_Utils(Node root){
		
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
		
		Node temp = this.root;
		while(temp!=null){
			s.push(temp);
			temp = temp.left;
			
		}
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
			top = s.pop();
		}
		return -1;
		
	} 
	
	
	// For binary tree
	public Node findNode(Node root, int value) {
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			Node temp = q.poll();
			if(temp.data == value) {
				return temp;
			}
			if(temp.left!=null){
				q.add(temp.left);
			}
			if(temp.right!=null) {
				q.add(temp.right);
			}
			
		}
		return null;
	}
	
	//Question 8: better way
	public Node findCommonAncestor(Node root, Node n1, Node n2){
		if(!cover(root,n1)||!cover(root,n2)){
			return null;
		}
		return ca_helper(root, n1,n2);
	}
	
	
	public Node ca_helper(Node root, Node n1, Node n2){
		// this has a problem : Base case is not correct
		if(root==null || root == p|| root == q) {
			//was root earlier
			return null;
		}
		if(root.data == n1.data || root.data == n2.data) {
			return root
		}
		boolean isPonLeft = cover(root.left, n1);
		boolean isQonLeft = cover(root.right, n2);
		if(isPonLeft != isQonLeft) {
			return root;
		}
		Node child = isPonLeft?root.left:root.right;
		return ca_helper(child, n1, n2);		
	}
	
	public boolean cover(Node root, Node n){
		if(root == null) {
			return false;
		} else if(root == n) {
			return true;
		} else {
			return cover(root.left, n) || cover(root.right, n);
		}
	}
		
	public static void main(String[] args) {
		int[] vals = {2,4,6,8,10,16,27};
		Node root = createMinBST(vals, 0, vals.length-1);
		Tree t = new Tree(root);
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
		System.out.println("node 1:"+n1.data);
		Node n2 = t.findNode(root, 27);
		System.out.println("node 2:"+n2.data);
		//System.out.println("LCA :"+t.findCommonAncestor(root,n1, n2).data);
		
		
	}
}