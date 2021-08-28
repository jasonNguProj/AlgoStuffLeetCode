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
to solve this problem we first do a fxn to swap
the nodes then we call our swap fxn on the right n left tree
O(N) time | O(N) space worst, O(log N) average
*/
class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        if(root == null) return null;
        swap(root);
        invertTree(root.left);
        invertTree(root.right); 
        
        return root;
    }
    
    public void swap(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}