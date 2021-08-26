/*
to solve this question we need to understand that we need
only one occurence of a xter, a hashmap will help us for this purpose
hence whenever we see a xter we updtae our start pos to be the max 
of start and the first position the xter occured plus 1 to start from the next index
so as to avoid repeating xters. then we just put if not present 
key is xter and the value is the index , the following sliding the window standards
we find our longest .
dnt forget edge cases
this fxn is O(N) space - time complexity

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int start=0, end = 0, longest = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        while(end < s.length()){
            
            char endVal = s.charAt(end);
            if(map.containsKey(endVal)){
                start = Math.max(start, map.get(endVal) + 1);
            }
            map.put(endVal, end);
            
            longest = Math.max(end - start + 1, longest);
            end++;
        }
        return longest;
        
    }
}