/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/


/*

to solve this question we have to do two things
we have to put our original againgst our copy in the map which
in essense is creating a new node
we now have to reassign our next and random pointer
and in the end we return our value section of hash map
time is O(N) | space is O(1) because we are storing sme nodes and they are not new nodes 

*/
class Solution {
    public Node copyRandomList(Node head) {
        
        Node current = head;
        HashMap<Node, Node> map= new HashMap<>();
        while(current != null){
            map.put(current, new Node(current.val));
                current = current.next;
        }
        //current = head;
        
        for(Map.Entry<Node, Node> entry : map.entrySet()){
            Node node = entry.getValue();
            node.next = map.get(entry.getKey().next);
            node.random = map.get(entry.getKey().random);
        }
        
        return map.get(head);
    }
}