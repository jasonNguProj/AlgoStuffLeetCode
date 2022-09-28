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
to solve this question we will use bfs
and some little twicks
we will need a result array to insert our results

1, 2,3, 5, 4
*/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        
        while(queue.size() > 0){
            int size = queue.size();
            
            for (int i = 0; i < size; i++){
                TreeNode current = queue.poll();
             if(i == size - 1)  result.add(current.val);
                
                if(current.left != null) queue.offer(current.left);
                 if(current.right != null) queue.offer(current.right);
            }
        }
        return result;
    }
}