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
//Using bfs trvarse via every level
// and add in the left and right tree
// also have a running sum
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        int sumOfCurrLevel = 0;
        while(!qu.isEmpty()){
            int size = qu.size();
            sumOfCurrLevel = 0;
            while(size-->0){
                TreeNode head = qu.poll();
                sumOfCurrLevel += head.val;
                if(head.left!=null){
                    qu.offer(head.left);
                }
                if(head.right!=null){
                    qu.offer(head.right);
                }
            }
        }
        return sumOfCurrLevel ;
    }
}