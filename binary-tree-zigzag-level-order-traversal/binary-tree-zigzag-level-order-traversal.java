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
to solve this qxn optimaly we will use BFS 
and traverse each level using a queue
and then set direction at the begin to true 
because we are going in zigzag manner 
so if true it should just add left first
add right first when dir is fals e



*/
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean direction = true;
        if(root == null) return result;
        
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);
            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                
                if(direction){
                   level.add(current.val);  
                } else{
                    level.add(0, current.val);
                }
                
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
                
               
            }
            result.add(level);
             direction = !direction;
        }
        
        return result;
    }
}