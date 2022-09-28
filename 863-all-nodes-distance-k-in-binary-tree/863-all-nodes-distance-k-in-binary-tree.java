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
to solve this problem firstly convert the tree into a graph
to get information of the parent because when we have info
parent will be a map containing either its left n right child
of the parent we can easily calc dist
then now we do a bfs using our target as start
since we are potentially traversing as though it was a graph 
we need a visted flag for visited nodes 
then we traverse the tree whenever we poll we check if its null or in our visited set
we continue and add node to visited also add nodes when ever the level ,
while travelling level is k then we add into our list 
O(N) Space-Time complexity

*/
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        dfs(root, parent);
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        int level = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                
                if(node == null || visited.contains(node)) continue;
                
                visited.add(node);
                
                if(level == k){
                    res.add(node.val);
                }
                queue.offer(node.left);
                 queue.offer(node.right);
                 queue.offer(parent.get(node));
            }
            level++;
        }
        return res;
    }
    
    public void dfs(TreeNode root, HashMap<TreeNode, TreeNode> parent){
        if(root == null) return;
        
        if(root.left != null) parent.put(root.left, root);
         if(root.right != null) parent.put(root.right, root);
        
        dfs(root.left, parent);
         dfs(root.right, parent);
    }
}