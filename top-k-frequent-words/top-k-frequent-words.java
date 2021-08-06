/*
to solve this problem we will use hastable together with a hmap
trav via the string put in a hashmapthen heap 
so the terminating condition so we first traverse the string up to k and put in a hmap 
then max heap
then now we traverse again starting at k 
if the value arry of k is gretaer than the peek we pop the peek and add into our result list;

*/

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        List<String> result = new ArrayList<>();
        if(words.length == 0 || words == null) return result;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < words.length; i++){
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(
            (e1, e2) -> e1.getValue() == e2.getValue() ? e1.getKey().compareTo(e2.getKey()) : e2.getValue() - e1.getValue());
        maxHeap.addAll(map.entrySet());
        
        while(k > 0 && !maxHeap.isEmpty()){
                result.add(maxHeap.poll().getKey());
            k--;
            }
        return result;
    }
}