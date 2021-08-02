/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
/*
to solve this problem looking at the out put they can be integers in the list 
and there can be a nested list 
so we'll use queu ds, to insert the integers
and a helper fxn which is recursive that adds if its a disgit else traverse the list
then inorder for hasnext the queue is not empty else fasle
for next if hasnext then we return queue.poll else -1;
 O(N + D) Space d space because of recursive stack


constructor is O(N + L) becase we travers in the inner list and there will be a total of N iterations
next and hasNest is O(1)time complexity


*/
public class NestedIterator implements Iterator<Integer> {

    Queue<Integer> queue = new LinkedList<>();
    
    public NestedIterator(List<NestedInteger> nestedList) {
        helper(nestedList);
    }

    public void helper(List<NestedInteger> nestedList){
        
        if(nestedList == null) return;
        
        for(NestedInteger nested : nestedList){
            if(nested.isInteger()){
                queue.offer(nested.getInteger());
            }else{
                helper(nested.getList());
            }
        }
        
    }
    @Override
    public Integer next() {
        
//         if(hasNext()){
//             return queue.poll();
//         }
//         return -1;
        return  hasNext() ? queue.poll() : -1;
    }

    @Override
    public boolean hasNext() {
        // if(!queue.isEmpty()){
        //     return true;
        // }else {
        //    return  false;
        // }
        
        return !queue.isEmpty()? true : false;
        
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */