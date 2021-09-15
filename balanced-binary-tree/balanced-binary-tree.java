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
to solve this problem firstly we have to understand that we neeed the height
because the height will give us the info of whether the tree is balanced or not 
note than when ever u are asked depth, height , length to solve it basically 
is to take max of the recursion on left and right + 1 
because in essence math.max of left and right + 1 gets called on every level
of the tree like basically behaves like recursion rather than adding up 1 at every level in the tree


*/
class Solution {
    public boolean isBalanced(TreeNode root) {
        
        if(root == null) return true;
        
        if(Math.abs(computHeight(root.left) - computHeight(root.right)) > 1) return false;
           
           return isBalanced(root.left) && isBalanced(root.right);
        
    }
    
    public int computHeight(TreeNode root){
        if(root == null) return 0;
        
        int left = computHeight(root.left) + 1;
        int right = computHeight(root.right) + 1;
        
        return Math.max(left, right);
    }
}