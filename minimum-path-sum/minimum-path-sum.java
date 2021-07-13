
//so we form a new array of same size 
// we travers to the end of the row and add i-1 + curren and same thing for col and add i-j plus current 
// then we traverse to get the min btw the val above and the val to the left of
// we start the matrix at 1 cus to get to 1 is  zero dist plus 1
class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        //top down fashion here the boundary is cols because we are going left to right in row , different nums(cols)
        for(int i = 1; i < col; i++){
            grid[0][i] += grid[0][i-1];
        }
        
        //top down fashion here the boundary is cols because we are going left to right in row , different nums(cols)
        for(int j = 1; j < row; j++){
            grid[j][0] += grid[j-1][0];
        }
        
        
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j - 1]);
            }
        }
        
        return grid[row - 1][col - 1];
    }
}