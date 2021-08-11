/*
to solve this question we will use a hashMap and a doubly linkedlist
our doublie ll will have a head and a tail
so like       Next
< null---head ---> tail---> null
              <prev--   
so we will have a node class that will have our node and tail
and we need to implement insert and remove fxn of our nod e
then we will use our remove and insert in ou LRU cache operations
we use hasp map and linked list because the remove and insert in ll 
is O(1) operation manipuling pointers similary the get and put fxn of map
is O(1)
*/ 


class Node{
    int key, value;
    Node head, tail;
    Node prev, next;
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    int capacity;
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    Map<Integer, Node>   map = new HashMap<>();

    public LRUCache(int capacity) {
         this.capacity = capacity;
        tail.prev =head;
        head.next = tail;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }else {
            return -1;
        }
        
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        
        if(map.size() == capacity){
            remove(tail.prev);
        }
        insert(new Node(key , value));
    }
    
    public void insert(Node node){
        map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }
     public void remove(Node node){
         map.remove(node.key);
         node.prev.next = node.next;
         node.next.prev = node.prev;
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */