/*
basically we will solve this using dfs simulate taking the index and adding to resul
and simulate not adding into result string
- so basically we'll have a separater fxn that does the recursion 
// and another funtion that does makesure we have unique pairs if not return length
// so to solve this we create an array that will hold our reult and update each time we have a result bigger than it 
*/
class Solution {
    public int maxLength(List<String> arr) {
        
        int[] res = new int[1];
        dfs(arr,0, "", res);
        return res[0];
    }
    
    public void dfs(List<String> arr, int index, String current, int[] result){
        
        if(index == arr.size() && maxUniquePairs(current) > result[0] ){
            result[0] = current.length();
                return;
        }
        
        if(index == arr.size()){
            return;
        }
         
            dfs(arr, index + 1 , current, result);
             dfs(arr, index + 1 , current + arr.get(index), result);
        }
    
    public int maxUniquePairs(String s){
              int[] count = new int[26];
       for(char c : s.toCharArray()){
           if(count[c - 'a']++ > 0){
               return -1;
           }
       }
    return s.length();
    }
}