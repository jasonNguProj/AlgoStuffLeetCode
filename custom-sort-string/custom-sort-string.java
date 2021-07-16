//to solve this question we traverse via the longer string and add them in a hmap
//then we check if xtres in our original sring is contained in our hmap
// if its not we skip it , so continue
// then we add the ones at are present in our original str into our res variable
//the we remove what we just appended from our hmap
//finally we traverse the remaining elements in our hmap and add to our res variable
//in the end we return res.toString
//rem we traverse we set the bounds less than freq of xtres in hmap
//we use a linkedHmap because it maintains the order nwhich it was inserted as the question is asking us to maintain that

// the space complexity is O(Longet string) || and time comp O(smallstring.length + longeststr.length)
class Solution {
    public String customSortString(String order, String str) {
        
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(char c : str.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(char c2 : order.toCharArray()){
            if(!map.containsKey(c2)) continue;
            
            for(int i = 0; i < map.get(c2); i++) {
                sb.append(c2);
            }
            map.remove(c2);
                
        }
        
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            for(int i = 0; i < entry.getValue(); i++)
                    sb.append(entry.getKey());
        }
        
        return sb.toString();
        
        
    }
}