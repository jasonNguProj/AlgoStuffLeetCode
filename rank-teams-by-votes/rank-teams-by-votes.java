/*
to solve this question couple of things
we build a 2 d array of the three elements and add an extra one 
for the elments say a 
then we update the counts of the element in out 2d array
then sort the element
lasty build our string via string builder


*/

class Solution {
    public String rankTeams(String[] votes) {
        
        int len = votes[0].length();
        int[][] rank = new int[26][len + 1];
        
        for(int i = 0; i < 26; i++) rank[i][len]  = i;
        
        for(int i = 0; i < votes.length; i++){
            String vote = votes[i];
            for(int j = 0; j < len; j++){
                rank[vote.charAt(j) - 'A'][j]++;
            }
        }
        
        Arrays.sort(rank, (a,b) -> {
            for(int i = 0; i < len; i++){
                if(a[i] > b[i]) return -1;
                if(b[i] > a[i]) return 1;
            }
            
        return 0;
         });
        
        StringBuilder sb =  new StringBuilder();
        for(int i = 0; i < len; i++){
              sb.append((char) ('A' + rank[i][len]));
        }
        return sb.toString();
          
    }
            
}