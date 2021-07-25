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
to solve this question we will solve it recursively
and find the max btw the diameter and left + right
then at every node to find diameter is the max btw lft and right + 1 (because of its parent node)

*/
class Solution {
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        computeDiameter(root);
        return diameter;  
    }
    
    public int computeDiameter(TreeNode root) {
        
        if (root == null) return 0;
        
        int left = computeDiameter(root.left);
        int right = computeDiameter(root.right);
        
        diameter = Math.max(diameter, left + right);
        
        return Math.max(left, right) + 1;
    }
}