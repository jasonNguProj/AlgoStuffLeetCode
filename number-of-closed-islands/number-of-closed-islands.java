/*
to solve this question well check when ever we are at 0 , which is land and not yet
visited we call our dfs fxn and then increment the count
we'll solve using dfs preorder traversal v via recursion and keep a visited flag for all visited

*/

class Solution {
    public int closedIsland(int[][] grid) {
        
        int countIsland = 0;
        int row = grid.length;
        int col = grid[0].length;
        
        if(row == 0) return 0;
        
        boolean[][] visited = new boolean[row][col];
        
          for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            if( i ==0 || j == 0 || i == grid.length-1 || j== grid[i].length-1){
                if (grid[i][j] == 0 && !visited[i][j]){
                    dfs(grid, i, j, visited); 
                }
            }
        }
    }
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 0 && !visited[i][j]){
                    dfs(grid, i, j, visited);
                    countIsland++;
                }
            }
        }
        return countIsland;
    }
    
    public void dfs(int[][] grid, int i, int j, boolean[][] visited){
        
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 1 || visited[i][j]){
            return;
        }
        
       
       
        
        
        
        visited[i][j] = true;
        
        dfs(grid, i + 1, j, visited);
        dfs(grid, i - 1, j, visited);
        dfs(grid, i, j - 1, visited);
        dfs(grid, i, j + 1, visited);
    }
}