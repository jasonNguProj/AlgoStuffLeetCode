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
to solve this problem since we are summing up
the leaves at the last level we can use a level order 
traversal , and reset the sum to 0 each time and return the last sum of the last level
*/
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int res = 0;
        while(!queue.isEmpty()){
            int sum = 0;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                sum += current.val;
                
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }
            res = sum;
        }
        return res;
    }
}