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
to solve this qxn easily we will use recursion
so do a dfs preorder traverse lvel by level
recursively call fxn on left subtree then sum the level with 1 since we are going one step 
down
initialy our level is 0
O(N) time | O(H) because of the height of recursive stack


*/
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return result;
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode root, int level){
        
        if(result.size() == level) result.add(new ArrayList<>());
        
        result.get(level).add(root.val); 
        if(root.left != null) dfs(root.left, level + 1);
         if(root.right != null) dfs(root.right, level + 1);
    }
}