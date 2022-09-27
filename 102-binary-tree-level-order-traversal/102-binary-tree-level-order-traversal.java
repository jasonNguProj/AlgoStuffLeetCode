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
we will solve this question using bfs
time is o(n) because we use que for bfs traversal
baiscally we need a result array and notice that its a list of list
so via bfs the steps are use que and traverse untill empty
we poll current and add its children
as we poll we add to a result arry
and at each level traverse nodes and then add to queu


*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
       
        
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
         if (root == null) return result;
        
        queue.offer(root);
        
        while(!queue.isEmpty()){
            
            List<Integer> res = new ArrayList<>();
            
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                res.add(current.val);
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }
            result.add(res);
        }
        return result;
    }
}