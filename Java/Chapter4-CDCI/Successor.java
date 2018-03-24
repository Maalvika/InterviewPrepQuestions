import java.util.*;

public class Successor{
	
	class Node{
		int data;
		Node left, right, parent;
	
		public Node(int data){
			this.data = data;
		}
	}
	
	Node root = null; 
	
	public void makeTreeBST(int data){
		if(this.root == null) {
			//System.out.println("here if"+data);
			this.root = new Node(data);
		} else {
			//System.out.println("here else"+data);
			Node temp = new Node(data);
			Node n = findParentNode(root, data);
			System.out.println("else"+data);
			System.out.println("n"+n.data);
			if(data<=n.data) {
				n.left = temp;
				temp.parent = n;
			} else {
				n.right = temp;
				temp.parent = n;
			}
			
		}
	}
	
	public void makeTree(int data){
		if(this.root == null) {
			//System.out.println("here if"+data);
			this.root = new Node(data);
		} else {
			//System.out.println("here else"+data);
			Node temp = new Node(data);
			Node n = findAvailableNode(root);
			//System.out.println("else"+data);
			//System.out.println("n"+n.data);
			if(n.left==null) {
				n.left = temp;
				temp.parent = n;
			} else {
				n.right = temp;
				temp.parent = n;
			}
			
		}
	}
	
	public Node findAvailableNode(Node root){
		//System.out.println("root:"+root.data);
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			Node temp = q.remove();
			if(temp.left==null || temp.right==null) {
				return temp;
			}
			q.add(temp.left);
			q.add(temp.right);
		}
		return null;
	}
	
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
	
	public Node findParentNode(Node root, int data){
		//System.out.println("root:"+root.data);
		if(root.left== null && data<=root.data){
			return root;
		} else if (root.right== null && data>root.data){
			return root;
		}else {
			if(data<=root.data) {
				return findParentNode(root.left,data);
			} else {
				return findParentNode(root.right,data);
			}
		}
		
		
	}
	
	
	public Node findNodeBST(Node root, int data) {
		if(root.data == data) {
			return root;
		} else {
			if(data<=root.data) {
				return findNode(root.left, data);
			} else {
				return findNode(root.right, data);
			}
		}
		
	}
	
	public int findDepth(Node root){
		if(root == null) {
			return 0;
		} else {
			return Math.max(findDepth(root.left), findDepth(root.right)) +1;
		}
	}
	
	public int findDepthofNode(Node n){
		if(n.parent == null) {
			return 0;
		} else {
			return findDepth(n.parent) +1;
		}
	}
	
	// Question 8: common ancestor
	public Node findCommonAncestor(Node root, Node n1, Node n2){
		int delta = findDepthofNode(n1) - findDepthofNode(n2);
		//System.out.println("n1 depth:"+findDepthofNode(n1));
		//System.out.println("n2 depth:"+findDepthofNode(n2));
		Node f = delta > 0?n1:n2;//deep
		Node s = delta > 0?n2:n1;//shallow
		if(delta!=0) {
			s = moveUp(s, Math.abs(delta));
		}
		
		while(f!=s){
			if(f!=null) {
				System.out.println("f data"+f.data);
				f=f.parent;
			} 
			if (s!=null) {
				System.out.println("s data"+s.data);
				s=s.parent;
			}
		}
		
		return f;	
		
	}
	
	//Ques 8: Better way
	public Node findCommonAncestor2(Node root, Node n1, Node n2){
		// p or q isnt present in the tree
		if(!covers(root, p) || covers(root, q)) {
			return null;
		} else if(covers(p,q)) {
			return p;
		} else if(covers(q,p)) {
			return q;
		}
		
		Node sib = getSib(p);
		Node par = p.parent;
		while(!covers(sib,q)) {
			sib = getSib(par);
			par = par.parent;
		}
		return par;
	}
	
	public boolean covers(Node par, Node n){
		if(par==null){
			return false;
		}
		if(par.data == n.data){
			return true;
		} else{
			return covers(par.left)|| covers(par.right);
		}
	}
	
	public Node getSib(Node n) {
		if(n == null || n.parent==null){
			return null;
		}
		Node par = n.parent;
		return par.right == n? par.left:par.right;
	}
	
	public Node moveUp(Node f, int level){
		
		if(level == 0) {
			return f;
		}
		return moveUp(f.parent, level-1);
	}
	
	public Node findSuccessor(Node n) {
		if(n.right != null) {
			return findMin(n.right);
		} else {
			Node p = n.parent;
			while(n.data>p.data) {
				p=p.parent;
			}
			return p;
		}
	}
	
	public Node findMin(Node n){
		Node temp = n;
		while(temp.left!=null) {
			temp=temp.left;
		}
		return temp;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {5,3,2,4,9,8,7,13};
		Successor succ = new Successor();
		for(int i:arr){
			succ.makeTree(i);
		}
		//System.out.println("Node data:"+succ.root.data);
		//System.out.println("Node parent:"+n.parent.data);
		//System.out.println("Node data:"+succ.root.left.data);
		//System.out.println("Node data:"+succ.root.right.data);
		int data = 4;
		//Node n = succ.findNode(succ.root, data);
		//Node n = succ.findSuccessor(temp);
		//System.out.println("Node data:"+n.data);
		//System.out.println("Node parent:"+n.parent.data);
		//System.out.println("Node data:"+n.left.data);
		//System.out.println("Node data:"+n.right.data);
		
		System.out.println("common ancestors: "+succ.findCommonAncestor(succ.root, succ.findNode(succ.root, 13), succ.findNode(succ.root, 9)).data);
		
		
	}
}