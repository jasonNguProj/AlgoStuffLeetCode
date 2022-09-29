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
to solve this question well find the max depth
then add elements at the max depth
wellsolve the question via bfs manner



*/
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        
        if(root ==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        
        int sum = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            sum = 0;
            int size = queue.size();
            
            for(int i =0; i < size; i++){
                TreeNode current = queue.poll();
                sum += current.val;
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }
        }
        return sum;
    }
}