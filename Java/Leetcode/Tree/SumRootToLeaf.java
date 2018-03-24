//////////////////////////129. Sum Root to Leaf Numbers

/////////////////////// Example:
/*
										 6
                                      /      \
                                    3          5
                                  /   \          \
                                 2     5          4  
                                      /   \
                                     7     4
  There are 4 leaves, hence 4 root to leaf paths:
   Path                    Number
  6->3->2                   632
  6->3->5->7               6357
  6->3->5->4               6354
  6->5>4                    654   
Answer = 632 + 6357 + 6354 + 654 = 13997 
*/
////// We need pre-order traversal. Evaluate root before we go left or right
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        LinkedList<Integer> li = new LinkedList<>();
        sumUtil(root, 0, li);
        int res = 0;
        for(int i: li) {
            res+=i;
        }
        return res;
    }
    
    public void sumUtil(TreeNode n, int prev, List<Integer> li) {
        if(n == null) {
            return;
        }
        if(n.left==null && n.right==null) {
            prev = prev*10 + n.val;
            li.add(prev);
            return;
        }
        prev = prev*10 + n.val;
        sumUtil(n.left, prev, li);
        sumUtil(n.right, prev, li);
    }
}