/*to solve this question we will keep a runing length of 
window of distinct xters by the time the size of map is greater 
than 2 then we shrink the window, and remove the value
O(N) Space-time complexity dnt foget to check edge cases when the string is null*/

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        if(s == null || s.length() == 0) return -1;
        Map<Character, Integer> map = new HashMap<>();
        int start =0, end = 0, maxLen = 0;
        
        while(end < s.length()){
            char endVal = s.charAt(end);
            map.put(endVal, map.getOrDefault(endVal, 0) + 1);
            
            if(map.size() > 2){
                char startVal = s.charAt(start);
                map.put(startVal, map.get(startVal) - 1);
                
                if(map.get(startVal) == 0){
                    map.remove(startVal);
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        return maxLen;
    }
}