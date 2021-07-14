// we first traverse the rows by col
// we can solve using dfs recursive 
// so we will call the recursive fxn in 4 directions
// if we can complete the four directions we increase count to 1
// we increment the count when we encounter zeros in all dirstions 
// we use a visited array to mark when we have passed via ones

//[1,1,0]
//[0,1,0]

class Solution {
    public int numIslands(char[][] grid) {
        
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                count++;
                }
                    
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, int i , int j){
        
        if( i  < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] != '1')
                return;
        
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i , j - 1);
        dfs(grid, i , j + 1);
    }
}