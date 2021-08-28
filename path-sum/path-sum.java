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

/*
to solve this our base case will be if the 
root.val == 0 we return true that theres a path else false
then we call our fxn on the left and right branch recursively

*/
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        if(root == null ) return false;
        
         if(root.left == null && root.right == null && targetSum - root.val == 0) return true;
        
        boolean left = hasPathSum(root.left, targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);
        
        return left || right;
    }
}