import java.util.*;

public class TreeOps {
	
	class Node {
		Node left;
		Node right;
		int data;
		
		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	
	/* you only have to complete the function given below.  
	Node is defined as  

	class Node {
		int data;
		Node left;
		Node right;
	}
	PreOrder: Root Left Right
	*/

	void preOrder(Node root) {
		if (root == null ){
			return;
		}
		if(root.left == null && root.right == null) {
			System.out.print(root.data+" ");
		} else {
			System.out.print(root.data+" ");
			preOrder(root.left);
			preOrder(root.right);
			
		}

	}
	/*
	Node is defined as  

	class Node {
		int data;
		Node left;
		Node right;
	}
	POST ORDER - Left Right Root
	*/

	void postOrder(Node root) {
    
		if (root == null ){
			return;
		}
		if(root.left == null && root.right == null) {
			System.out.print(root.data+" ");
		} else {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data+" ");
			
		}

	}
	
	/*   
	Node is defined as  

	class Node {
		int data;
		Node left;
		Node right;
	}
	INORDER - LEFT ROOT RIGHT
	*/

	void inOrder(Node root) {
		
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
	///////////////////////////////////////////// FIND HEIGHT OF BINARY TREE//////////////////////////
	
	static int height(Node root) {
      	// Write your code here.
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 0;
        } else {
            return Math.max(1 + height(root.right), 1 + height(root.left));
        }
    }
	
	public static Node insert(Node root, int data) {
        if(root == null){
            return new Node(data);
        }
        else {
            Node cur;
            if(data <= root.data){
                cur = insert(root.left, data);
                root.left = cur;
            }
            else{
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
	
	//////////////////////////////////// FIND COMMON ANCESTOR///////////////////////////////
	static Node lca(Node root,int v1,int v2)
    {
        if(v1<v2) {
          return findAncestor(root, v1, v2);
        }
        return findAncestor(root, v2, v1);
    }

	public static Node findAncestor(Node n, int v1, int v2){
    
		if(n == null) {
			return null;
		} 
		if(v1<n.data && v2<n.data) {
			return findAncestor(n.left, v1,v2);
		}
		if(v1>n.data && v2>n.data) {
			return findAncestor(n.right, v1,v2);
		}
		
		return n;
    
    
	}
	
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0){
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }



}