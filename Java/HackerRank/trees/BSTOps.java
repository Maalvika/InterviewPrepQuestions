import java.util.*;

public class BSTOps {
	
	
	static class Node	{
	
		int data;
		Node left; 
		Node right;
	
		public Node(int d) {
			this.data = d;
			left = right = null;
		}
	}
	
	static Node root = null;
	/////////////////// CONSTRUCT A BST//////////
	
	public static void insert(Node curr, Node n){
		if(curr== null) {
			curr = n;
			return;
		} else if(n.data> curr.data){
			if(curr.right == null) {
				curr.right = n;
				return;
			}
			insert(curr.right, n);
		} else if(n.data < curr.data) {
			if(curr.left == null) {
				curr.left = n;
				return;
			}
			insert(curr.left, n);
		}
		
	}
	
	//////////////////////// INORDER TRAVELSAL///////////////////////
	
	static void inOrder(Node root) {
		
		if (root == null ){
				return;
		}
		if(root.left == null && root.right == null) {
			System.out.print(root.data+" ");
		} else {
			inOrder(root.left);
			System.out.print(root.data+" ");	
			inOrder(root.right);
		}

	}
	
	////////////////////// CHECK IF TREE IS A BST///////////////
	static boolean checkBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        
    }
    static boolean isBST(Node n, int min, int max) {
        if(n == null) {
            return true;
        } else {
            if(n.data < min || n.data > max){
                return false;
            }
            return (isBST(n.left, min, n.data-1)) && (isBST(n.right, n.data + 1, max));
        }
    }
	
	public static void main(String[] args) {
	
		root = new Node(50);
		int[] nodes = {30,20, 40,70,60,80};
		for(int i: nodes) {
			insert(root, new Node(i));
		}
		inOrder(root);
		System.out.println("\nIs BST?!"+checkBST(root));
		
	}
}