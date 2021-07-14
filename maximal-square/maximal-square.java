// so we'll basically solve this via dynamic programming
// set var for max sq
// then create a dp array to keep track of maxsq
//we preserve the first row and col in our original matrix because the min btw ththem at the zero row or col is just there num
// so we start the for loops at 1 
// and to insert in out new array we get the min, from left, top and diagonal and add 1
// then get the max btw dp and max var
//in the end we return max * max since we are looking ofr the area 
class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) 
                return 0;
        
        int row = matrix.length;
        int col = matrix[0].length;
        int max  = 0;
        
        int[][] dp = new int[row + 1][col + 1];
            
            for(int i = 1; i <= row ; i++){
                for(int j = 1; j <= col; j++){
                    if(matrix[i - 1][j - 1] == '1'){
                         dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                    }
                    
                }
            }
        
        return max * max;
  
        }
    }
