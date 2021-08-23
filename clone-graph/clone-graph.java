/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

/*

to solve this problem we will use a hmap to keep track of 
node as key and neighbor as value
note that a node contains a value and list of neighbors
so we traverse via bfs if not present add into visited
and into queuue  if present we get the neigbors clone and add its clone 
into the clone neighbor list

*/

class Solution {
    public Node cloneGraph(Node node) {
        
        if(node == null) return node;
        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val, new ArrayList<>()));
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        
        while(!queue.isEmpty()){
            Node n = queue.poll();
            
            for(Node neighbor : n.neighbors){
                if(!map.containsKey(neighbor)){
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                        queue.offer(neighbor);
                }
                // here we adding our neighbors clone to our neighbors
                // noote that neighbor is our value in a hashmap
                // so we are gting the polled nodes neighbors and adding it clone
                map.get(n).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
        
    }
}