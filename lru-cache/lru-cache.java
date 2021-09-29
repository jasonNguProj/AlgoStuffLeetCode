
/*
to solve this qxn i will use a hmap which has O(1) get and put
similary a linked list has O(1) insert and remove by maniulating pointers

head  <---prev-- taiL
      ----next-->
*/

class Node{
    Node prev, next, head, tail;
    int value, key;
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    int capacity;
    Map<Integer, Node> map;
    Node head = new Node(0, 0);
     Node tail = new Node(0, 0);
    public LRUCache(int capacity) {
         map = new HashMap<>();
        this.capacity = capacity;
         head.next = tail;
         tail.prev = head;
    }
    
     public int get(int key) {
         if(map.containsKey(key)){
             Node node = map.get(key);
             remove(node);
             insert(node);
             return node.value;
         } else {
             return -1;
         }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
           Node node = map.get(key); 
            remove(node);
        }
        
        if(map.size() >= capacity){
            remove(tail.prev);
        }
        insert(new Node(key, value));
        
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