/*
to solve this problem we need to undertand that 
we need only unique xters in a window , and when ever 
our current window is equal to k we just incrment our count nad takeout the xtr at 
start and increment
*/

class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        
        int start =0, end =0, res = 0;
        
        Set<Character> set = new HashSet<>();
        while(end < s.length()){
            while(set.contains(s.charAt(end))){
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(end));
            
            if(end - start + 1 == k){
                res++;
                set.remove(s.charAt(start));
                start++;
            }
            end++;
        }
        return res;
    }
}