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
we can solve this preorder dfs and trav left tree and right tree

*/
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        levelOrderBotton(root, 0, result);
            Collections.reverse(result);
        return result;
    }
    
    private void levelOrderBotton(TreeNode root, int level, List<List<Integer>> result){
        
        if(result.size() == level){
            result.add(new ArrayList<>());
        }
        
        result.get(level).add(root.val);
       if(root.left != null) levelOrderBotton(root.left, level + 1, result);
         if(root.right != null)levelOrderBotton(root.right, level + 1, result);
    }
}