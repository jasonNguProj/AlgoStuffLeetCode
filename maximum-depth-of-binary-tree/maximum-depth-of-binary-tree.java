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
when ever u here depth of something know that u have to use
dfs recursion, so to solve this question as we go deep 
we call our fxn recursively on the left and right tree
and add 1, we add 1 because at each level the depth is 1
O(N) Space and o(log N) on average and O(N) in the worst case
when the tree is skewed meaning when the tree has one root linking many children;
*/
class Solution {
    public int maxDepth(TreeNode root) {
        return computeDepth(root);
    }
    
    private int computeDepth(TreeNode root){
        if(root == null) return 0;
        
        int left = computeDepth(root.left);
        int right = computeDepth(root.right);
        return Math.max(left, right) + 1;
    }
}