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
O(N) time cus we traverse via each node in the tree to get its value| O(H) space because of the recursive stack




*/
class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        
        inorderTraversal(root, result);
        return result;
    }
    
    public void inorderTraversal(TreeNode root, List<Integer> res){
        
        if(root == null) return;
       inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);
    }
}