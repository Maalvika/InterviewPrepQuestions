//////////////////// Problem 94. Binary Tree Inorder Traversal
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class InorderTravelsalList {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> li = new LinkedList<>();
        inorderUtil(root, li);
        return li;
    }
    
    public void inorderUtil(TreeNode node, List<Integer> li) {
        if(node == null) {
            return;
        }
        inorderUtil(node.left, li);
        li.add(node.val);
        inorderUtil(node.right, li);
        
    }
}