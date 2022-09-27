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
to solve this question we need to understand what
cousins are, to be cousins parents are suppose to be diffent and same level
so well solve via bfs but with an addition to keep track of rparents in a map

*/


class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root == null) return false;
        
        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        boolean foundX = false;
        boolean foundY = false;
        
        queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                
                for(int i =0; i <size; i++){
                    TreeNode current = queue.poll();
                    
                    if(current.val == x) foundX = true;
                    if(current.val == y) foundY = true;
                    
                    if(current.left != null){
                        queue.offer(current.left);
                        map.put(current.left.val, current.val);
                    }
                    
                     if(current.right != null){
                        queue.offer(current.right);
                        map.put(current.right.val, current.val);
                    }
                    
                }
                
                if((foundX && !foundY) || (!foundX && foundY)) return false;
                if((foundX && foundY) && (map.get(x) != map.get(y))) return true;
                
            }
        return false;
        
    }
}