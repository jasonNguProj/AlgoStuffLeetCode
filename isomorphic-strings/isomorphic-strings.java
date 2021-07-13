// we'll store 2 diff arrays that hold count of each array
// if count in a not same as count in b return false
// else return true 
// when we meet a xter we increase the count
// O(N) time cus we traverse the array and O(1) space because there are 128 constant xters in the alphabeth;
class Solution {
    public boolean isIsomorphic(String s, String t) {
    
        if(s.length() != t.length()) return false;
    int[] arr1 = new int[128];
        int[] arr2 = new int[128];
        
        for(int i = 0; i < s.length(); i++){
            if(arr1[s.charAt(i)] != arr2[t.charAt(i)]) return false; 
            arr1[s.charAt(i)]  = i + 1;
            arr2[t.charAt(i)]  = i + 1;
        }
    return true;
    
                            
           
    }
}