
/*
to solve this question we will use an arraylist and a map
which will help us during remove 
and also provides an O(1) for random fxn so we need to initialize random

*/

class RandomizedSet {

    Map<Integer, Integer> map;
    List<Integer> arr;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        arr = new ArrayList<>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        
        map.put(val, arr.size());
        arr.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        
        if(!map.containsKey(val)) return false;
        
        int index = map.get(val);
        int lstElement = arr.get(arr.size() - 1);
        arr.set(index, lstElement);
        
        map.put(lstElement, index);
        map.remove(val);
        arr.remove(arr.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = random.nextInt(arr.size());
        return arr.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */