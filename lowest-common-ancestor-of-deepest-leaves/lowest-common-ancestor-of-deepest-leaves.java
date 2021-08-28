/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/*to solve this problem 
we find the depest level of the node via finding the max height
and then when ever our level is equal to left and to the right 
then we update our root value */
class Solution {
    int deepestLevel = 0;
    TreeNode res = null;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        computeDeepest(root, 0);
        return res;
    }
    
    private int computeDeepest(TreeNode root, int level){
        
        if(root == null) return level;
        
        int left = computeDeepest(root.left, level + 1 );
         int right = computeDeepest(root.right, level + 1 );
        
        int current = Math.max(left, right);
        deepestLevel = Math.max(current, deepestLevel);
        
        if(left == deepestLevel && right == deepestLevel){
            res = root;
        }
        return current;
    }
}