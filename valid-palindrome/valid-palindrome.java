/*
to check if a fxn is a palindrome
firstly the promt gives us that non digits are 
parts of the strings and should not be counted 
so we check that visa 2 pointers 
and then when we hve ignored the non digits 
we check is the front is not equal to last we return false 
move our pointers inwards else return true 

*/

class Solution {
    public boolean isPalindrome(String s) {
        
        int start = 0;
        int end = s.length() - 1;
        while(start <= end){
            if(!Character.isLetterOrDigit(s.charAt(start))){
                start++;
                continue;
            }
            
              if(!Character.isLetterOrDigit(s.charAt(end))){
                end--;
                continue;
            }
            
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) return false;
            
             if (Character.toLowerCase(s.charAt(start)) == Character.toLowerCase(s.charAt(end))){
                 start++;
            end--; 
             }
              
        }
        return true ;
    }
}