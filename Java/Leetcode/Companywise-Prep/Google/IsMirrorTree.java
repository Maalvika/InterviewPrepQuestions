import java.util.*;

public class IsMirrorTree{
	
	class Node{
		int val;
		Node left, right;
		public Node(int val){
			this.val = val;
			left = right = null;
		}
	}
	
	
	public boolean isMirror(Node root) {
		
	}
	
	public boolean isMirror_helper(Node n1, Node n2) {
		if(n1==null && n2 == null) {
			return true;
		}
		if(n1==null || n2==null || n1.val!=n2.val) {
			return false;
		}
		
		return isMirror_helper(n1.left, n2.right) && isMirror(n2.left, n1.right);
	}
	
	public static void main(String[] args) {
		
	}
}