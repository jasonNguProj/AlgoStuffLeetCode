/*
to solve this problem we will keep track of every xter ending 
and then update and take the max of a xter in a particular window
when ever when we loop via the xter and then it reaches the max we just find the length and add 
into our list
subsequently we want to start at the 0 + 1 index for the next xter
we solve using O(N) time O(1) space since the letters of the alphabeth has a max of 26 xters



*/


class Solution {
    public List<Integer> partitionLabels(String S) {
   
        int[] map = new int[26];
        for(int i = 0; i < S.length(); i++){
            map[S.charAt(i) - 'a'] = i;
        }
        int start = 0, max = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < S.length(); i++){
            max = Math.max(max,map[S.charAt(i) - 'a'] );
            
            if(i == max){
                res.add(max - start + 1);
                 start = i + 1;
            }
           
        }
        return res;
    }
}