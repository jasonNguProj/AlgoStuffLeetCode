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
at the beginning it is said that a null node is a valid bst bcus its btwn min, max
to check if a tree is valid we have to check withing a range
the range we check is between int min and int max value 
if the tree value are between this range we return true else false
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        return checkNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean checkNode(TreeNode root, long min, long max){
        
        if (root == null) return true;
        
        else if ((root.val > min)  && (root.val < max)){
            return (checkNode(root.left, min, root.val) && checkNode(root.right, root.val, max));
        } else {
            return false;
        }
    }
}