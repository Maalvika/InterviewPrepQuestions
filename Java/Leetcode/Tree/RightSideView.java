/////////////////////////////// Problem 199. Binary Tree Right Side View
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> li = new LinkedList<>();
        rightsideUtil(root, li);
        return li;
        
    }
    
     public void rightsideUtil(TreeNode node, List<Integer> li) {
        int d = getDepth(node);
         for(int i=1; i<=d; i++) {
             LinkedList<Integer> temp = new LinkedList();
             levelOrder(node, temp, i);
             li.add(temp.get(temp.size()-1));
         }
        
     }
    
    public void levelOrder(TreeNode n, List<Integer> li, int l) {
        if(n == null) {
            return;
        } 
        if(l == 1) {
            li.add(n.val);
        } else {
            levelOrder(n.left, li, l-1);
            levelOrder(n.right, li, l-1);
        }
        
    }
    
    public int getDepth(TreeNode n){
        if(n==null) {
            return 0;
        } else {
            return Math.max(getDepth(n.left), getDepth(n.right)) + 1;
        }
    }
	
	/////////////////////////////////////////// MORE EFFICIENT WAY/////////////////////
	
	/*
	*The above solution is not efficient because we are traversing both left subtree and right subtree
	*But we should traverse right subtree first and if we didnt have a value then only go to the left subtree till we reach max depth
	*/
	/* ALGORITHM:
	1. check if node is null or not
	2.check if max level < current 
		2.1 if yest update and add the node
		2.2 else do nothing
	3. recurse on the right node of the current
	4. recurse on the left node of the current
	*/
	
	int max_level = 0;
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> li = new LinkedList();
        levelOrder(root, li, 1);
        return li;
        
    }
    
    public void levelOrder1(TreeNode node, List<Integer> li, int level) {
        if(node == null) {
            return;
        }
        if(max_level < level) {
            li.add(node.val);
            max_level = level;
        }
        levelOrder(node.right, li, level+1);
        levelOrder(node.left, li, level+1);
    }
}