/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

/*
to solve this qxn optimaly well use bfs
this is an narry tree so the children a list of nodes
we'll traverse them and add in or queue
*/
class Solution {
    public int maxDepth(Node root) {
        
        if (root == null) return 0;
        int depth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
             
            int size = queue.size();
            for(int i = 0; i < size; i++){
                 Node node = queue.poll();
            for(Node child : node.children){
                queue.offer(child);
            }
            }
           depth++;
        }
        return depth;
        
    }
}