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
// copy the linked list
// reassign the next and random nodes
class Solution {
    public Node copyRandomList(Node head) {
        
        // O(N)  space | O(N) time
        if(head == null) return null;
        
        Node currentNode = head;
        Map<Node, Node> map = new HashMap<>();
        // copy node
        while(currentNode != null){
            map.put(currentNode, new Node(currentNode.val));
            currentNode = currentNode.next;
        }
       // currentNode =  head;
        
       // copy next and random 
        for(Map.Entry<Node, Node> entry: map.entrySet()){
            Node node = entry.getValue();
            node.next =map.get(entry.getKey().next);
            node.random = map.get(entry.getKey().random);
        }
        
        // while(currentNode != null){
        //     map.get(currentNode).next = map.get(currentNode.next);
        //      map.get(currentNode).random = map.get(currentNode.random);
        //     currentNode = currentNode.next;
        // }
        
        return map.get(head);
    }
}