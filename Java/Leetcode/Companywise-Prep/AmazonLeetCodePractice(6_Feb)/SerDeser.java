import java.util.*;

public class SerDeser {
	
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
		preOrderTraversal(root, sb);
		sb.remove(sb.lastIndexOf(", "));
		return sb.toString();
    }
	
	public void preOrderTraversal(TreeNode n, StringBuilder sb) {
		if(n !=null) {
			sb.append(n.val+", ");
		} else {
			sb.append("null, ");
		}
		preOrderTraversal(n.left, sb);
		preOrderTraversal(n.right,sb);
	}

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
    }
}
