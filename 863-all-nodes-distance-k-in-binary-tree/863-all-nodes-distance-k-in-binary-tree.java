/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
to solve this question we need information from our parent node
inoder to cal distance to children, and vice versa, 
so we need to conv the tree into an undirected graph
firstly we will conv the tree into graph via dfs preorder to build the tree 
then when ever our level is equal to our k, vlue because in essence we need to
return list of values that are at a dist k from target, meaning whenever our current levl is equal k, 
from target we just add values into our result list
so we need to first conv the tree into a graph
then travrse in a bfs manner, taken into cons that
its a graph, and we also have parent nodes 
O(N) space-time complexity, because we traverse the nodes, and use various ds

*/
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        List<Integer> result = new ArrayList<>();
        
        if(root == null) return result;
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        
        
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
            dfs(root, parent);
            queue.offer(target);
        int level = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                
                TreeNode current = queue.poll();
                
                if(current == null || visited.contains(current)) continue;
                visited.add(current);
                
                if(level == k) result.add(current.val);
                
                 queue.offer(current.left);
                 queue.offer(current.right);
                queue.offer(parent.get(current));
            }
            level++;
        }
        return result;
        
    }
    
    public void dfs(TreeNode root, Map<TreeNode, TreeNode> parent){
        
        if(root == null) return;
        
        if(root.left != null) parent.put(root.left, root);
           if(root.right != null) parent.put(root.right, root);
        
        dfs(root.left, parent);
             dfs(root.right, parent);
    }
}