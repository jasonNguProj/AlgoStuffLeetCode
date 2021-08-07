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
inordeer traversal we first check the left tree 
the add the value
then check right subtree;




*/
class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        
        inorderTraversal(root, result);
        return result;
    }
    
    public void inorderTraversal(TreeNode root, List<Integer> res){
        
        if(root == null) return;
        if(root.left != null) inorderTraversal(root.left, res);
        res.add(root.val);
        if(root.right != null) inorderTraversal(root.right, res);
    }
}