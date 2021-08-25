/*
this is another sliding the window tech nik 
problem where here we just hve a growing window
where if theres a vowel we increment our count
else by the time our growing window is biger than 
our set window given in the question we need to decrement our vowel count
and check if our window - k term is present in our hashmap
so we do :--

*/

class Solution {
    public int maxVowels(String s, int k) {
        
        int maxLength = 0, vowelCnt = 0;
        var vowel = Set.of('a', 'e', 'i', 'o', 'u');
        
        for(int i = 0 ; i < s.length(); i++){
            
            if(vowel.contains(s.charAt(i))) vowelCnt++;
            
            if(i >= k && vowel.contains(s.charAt(i - k))) vowelCnt--;
            
            maxLength = Math.max(maxLength, vowelCnt);
        }
        
        return maxLength;
        
    }
}