// use dfs to traverse in  4 dir
// if arry is 1 call dfs and increment counter by 1
// also we cnst move when 0 > i, j, and i and j >= grid.length, or 2d! = 1 return

class Solution {
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int island = 0;
        for(int i = 0; i < m; i++){
            for(int j =0; j < n; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    island++;
                }
            }
        }
        return island;
        
    }
    
    public void dfs(char[][] grid, int i,  int j){
        if( i< 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') return;
        
        grid[i][j] = '0';
        
        dfs(grid, i -1, j);
        dfs(grid, i +1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
            
    }
}