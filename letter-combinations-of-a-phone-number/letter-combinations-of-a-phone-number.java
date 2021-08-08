
/*

so in essense 23 gives us a string abcdef
becase its 2 numbers of 2 letters its going to generate 6 combinations
so we do a -[ae, ad, af] ae, 


*/

class Solution {
    public List<String> letterCombinations(String digits) {
         LinkedList<String> ans = new LinkedList<String>();
        if(digits.length() == 0) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        
        for(int i = 0; i < digits.length(); i++){
            int digit = digits.charAt(i) - '0';
            
            while(ans.peek().length() == i){
                String t = ans.remove();
                for(char s: mapping[digit].toCharArray())
                    ans.add(t + s);
            }
        }
        
        return ans;
    }
}