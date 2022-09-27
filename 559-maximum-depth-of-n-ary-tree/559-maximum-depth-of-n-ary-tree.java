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

to solve this question you need to understand that its an 
n-arry tree meaning any number of child nodes, 
so to solve this plroblem we will use bfs, where 
we create our que for traversal, input that first node
initialize height, and increment height
at eah level we chek size of the levl 
fe will traverse from each node andd add the children , and at the end return sizetime n space is O(N)
because we use a queu for bfs, and traverse via every node
*/

class Solution {
    public int maxDepth(Node root) {
        
        if(root == null) return 0;
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int maxDepth = 0;
        while(!queue.isEmpty()){
            maxDepth ++;
                int size = queue.size();
            
            for(int i = 0; i < size; i++){
                Node current = queue.poll();
                    
                    for(Node child : current.children)
                        queue.offer(child);
            }
          
        }
          return maxDepth;
    }
}