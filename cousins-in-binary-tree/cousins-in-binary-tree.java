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

we'll use a q to keep track of nodes
hashmap to keep track of cousins that is taking
its left and right value
if parent of x and y are not sme hence we got our cousin

*/
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root == null) return false;
        
        Queue<TreeNode> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        boolean foundX= false;
        boolean foundY = false;
        
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                
                if(node.val == x){
                    foundX = true;
                }
                
                 if(node.val == y){
                    foundY = true;
                }
                
                if(node.left != null){
                    queue.offer(node.left);
                    map.put(node.left.val, node.val);
                }
                
                if(node.right != null){
                    queue.offer(node.right);
                    map.put(node.right.val, node.val);
                }
            }
            
            if((foundX && !foundY) || (!foundX && foundY)){
                    return false;
                }
                
                if(foundX && foundY && map.get(x) != map.get(y)){
                    return true;
                }
            
        }
        
        return false;
        
    }
}