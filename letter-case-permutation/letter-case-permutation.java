/*
to solve this question we need to understand that each time
we are a xter that is a letter say a, we need to form 2 xters 
from it that is the xter itself and the uppercase xter
when we have a didit we just call a recursive fxn on the next letter
but when we are faced w a xter we form a lowercase branch and an uppercase 
brach then call our fxn recursively to explore the other branches



*/


class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        dfs(res, 0, s.toCharArray());
        return res;
    }
    
    public void dfs(List<String> res, int i, char[] s){
        
        if(i == s.length){
            res.add(new String(s));
        } else {     
            if(Character.isLetter(s[i])){
                s[i] = Character.toUpperCase(s[i]);
                dfs(res, i + 1, s);
                 s[i] = Character.toLowerCase(s[i]);
                dfs(res, i + 1, s);
            } else{
                 dfs(res, i + 1, s);
            }
        }
        
    }
}