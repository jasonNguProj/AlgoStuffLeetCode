class Solution {
    public String reverseVowels(String s) {
        
        char[] ch = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        var words = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O','U');
        while(start < end){
           if(!words.contains(ch[start])) {
               start++;
           }
             else if(!words.contains(ch[end])){
                 end--;
             } 
           else if (words.contains(ch[start]) && words.contains(ch[end])){
               swap(ch, start, end);
               start++;
               end--;
           }   
        }
    return new String(ch);
    }
    
    public void swap(char[] arr, int i, int j){
        
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}