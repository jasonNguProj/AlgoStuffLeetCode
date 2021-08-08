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
to solve this question we will use a hasp map to keep track of the orinal graph
as key and clone as value 
if we already visited a node we just return that clone
else we create the clone 
then traverse via neighbors in a tree getting each clone and put in the map 
done recursively

*/
class Solution {
    
    HashMap<Node, Node> map = new HashMap<>();;
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        if(map.containsKey(node)){
            return map.get(node);
        }
        
        Node clone = new Node(node.val, new ArrayList<>());
        map.put(node, clone);
        
        for(Node neighbor: node.neighbors){
            clone.neighbors.add(cloneGraph(neighbor));
        }
        
        return clone;
    }
}