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
to solve this qxn well use preorder dfs
add the node value into our array 
if either the left is null or right sub tree is null
and then call the tree recursively on the left and right tree
*/
class Solution {

    public List<Integer> getLonelyNodes(TreeNode root) {
        
        return dfs(root, new ArrayList<Integer>());
    }
    
    public List<Integer> dfs(TreeNode root, List<Integer> result){
        
        
        if(root == null) return result;
        
        if(root.left == null && root.right != null) {
            result.add(root.right.val);
        } else if(root.left != null && root.right == null){
             result.add(root.left.val);
        }
        
        dfs(root.left, result);
         dfs(root.right, result);
        
        return result;
    }
    
    
}