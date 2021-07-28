/*

so i think we put the elements in a hashmap
then traverse to get eaxh xter from value 
ad the values in a maxheap to sort elements by decreasing order 
then traverse the que and poll the first element in q
for ech value we return the key 
then we return stringBuilder
time is O(N log N);
Space is O(N)
*/

class Solution {
    public String frequencySort(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = 
            new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        
        maxHeap.addAll(map.entrySet());
        
       while(!maxHeap.isEmpty()){
           Map.Entry<Character, Integer> entry = maxHeap.poll();
           for(int i = 0; i < entry.getValue(); i++){
                sb.append(entry.getKey());
           }   
       }
        return sb.toString();
    }
}