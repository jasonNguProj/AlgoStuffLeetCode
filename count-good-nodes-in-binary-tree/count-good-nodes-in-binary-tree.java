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
/*to solve this question we have to undersatnd that in order for a node to be good
the present value should be greater than or equal to the previous value 
and then we just update our max and initialize our goodnode as a global variable to contol our recursion
*/
class Solution {
    
    int goodNode;
    public int goodNodes(TreeNode root) {  
       // goodNode = 0 ;
        dfs(root, Integer.MIN_VALUE);
        return goodNode;
    }
    
    private void dfs(TreeNode root, int max){
        if(root == null) return;
        
        if(root.val >= max){
            goodNode++;
        }
        max = Math.max(root.val, max);
        dfs(root.left, max);
         dfs(root.right, max);
    }
}