/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
to solve this question we will solve it via recursion and traverse in the left and right subtree 
calling the recursive fxn on the lft and right
then if the rightt is null return left
if the left is null root = right
the base case if root is null we return root 

*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) return null;
        
        if(p.val == root.val || q.val == root.val) return root; 
        
        TreeNode left= lowestCommonAncestor(root.left, p,q);
         TreeNode right = lowestCommonAncestor(root.right, p,q);
        
        if(left == null) return right;
        if(right == null) return left;
        
        return root;
    }
}