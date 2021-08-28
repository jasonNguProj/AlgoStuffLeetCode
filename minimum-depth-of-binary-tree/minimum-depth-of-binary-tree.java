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
this problem can be easily solved via bfs , but solving it
via dfs recursion is to recurse on the left and right 
and take the min of them and add one bcus at each level depth is 1
time is O(N) | space is O(N) because of recursive stack

*/
class Solution {
    public int minDepth(TreeNode root) {
        
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left == 0 || right == 0)
            return Math.max(left, right) + 1;
        return Math.min(left, right) + 1;
    }
}