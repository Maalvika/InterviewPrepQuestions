import java.util.*;

//Problem Number:297
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Ser_DeserBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        sb.setLength(sb.length()-1);
        String s = sb.toString();
        System.out.println("preorder:"+s);
        return sb.toString();
    }
    
    public void preOrder(TreeNode n, StringBuilder sb) {
        if(n==null) {
            sb.append("null,");
            return;
        }
        sb.append(n.val+",");
        preOrder(n.left, sb);
        preOrder(n.right, sb);
        
        
    }
    String[] nodes;
    int index = -1;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       nodes = data.split(",");
       // System.out.println(nodes.length);
       return constructPreOrder(); 
    }
    
    public TreeNode constructPreOrder(){
        index++;
        if(nodes[index].trim().equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodes[index]));
        node.left = constructPreOrder();
        node.right = constructPreOrder();
        return node;
    }
    
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));