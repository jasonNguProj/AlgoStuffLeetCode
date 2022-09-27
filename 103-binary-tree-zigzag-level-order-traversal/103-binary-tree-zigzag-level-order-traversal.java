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

to solve this question we'll use bfs
where, we need a result array, que for bfs
add into quee
get size of present q level
poll elements on that level 
and then add each of the children into the queue
then add all elements into result array 

*/
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        boolean direction = true;
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> res = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                if(direction) {
                  res.add(current.val);  
                } else {
                    res.add(0, current.val);  
                }
              
                if(current.left != null) queue.offer(current.left);
                 if(current.right != null) queue.offer(current.right);
            }
              
         result.add(res);
            direction = !direction;
    }
     return result;  
}
    
}
