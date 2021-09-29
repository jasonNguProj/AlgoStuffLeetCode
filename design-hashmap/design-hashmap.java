/*

Inorder to implement the hashmap to avoid collison
we will use buckets , meaning an array with linked list at a particular position
and the size of the array linkedlist will be a huge prime number say 2069\
then we need to prov a hsh fxn that will rep the index for us to store our entry
so we will create an entry class of key ,value in which we store our elements
or hashmaps as entries into our array

so this will be o(n/k) time comp n = num of key
k = number of buckets so it is n/k due to the fact that the keys are evenly distrubted
as a result we could coinder as an average the size of buckets to be N/K

Space complexity is O(K + M) k = buckets, M = unique keys
this is so because we strore our unique keys and buckets in the hashMap

*/



class MyHashMap {

    LinkedList<Entry>[] bucket;
    final int size = 2069;
    
    class Entry{
        int key;
        int value;
        
        public Entry(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    /** Initialize your data structure here. */
    public MyHashMap() {
        bucket = new LinkedList[size];
        for(int i = 0; i < bucket.length; i++){
            bucket[i] = new LinkedList<Entry>();
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getHash(key);
        LinkedList<Entry> entryList = bucket[index]; 
        if(get(key) != -1) remove(key);
        Entry entry = new Entry(key, value);
        entryList.add(entry);
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getHash(key);
        LinkedList<Entry> entryList = bucket[index];
        Iterator<Entry>  it = entryList.iterator();
        while(it.hasNext()){
            Entry entry = it.next();
            if(entry.key == key) return entry.value;
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
         int index = getHash(key);
        LinkedList<Entry> entryList = bucket[index];
        Iterator<Entry>  it = entryList.iterator();
        while(it.hasNext()){
             Entry entry = it.next();
            if(entry.key == key) it.remove();
        }
        
    }
    
    public int getHash(int key){
        return key % size;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */