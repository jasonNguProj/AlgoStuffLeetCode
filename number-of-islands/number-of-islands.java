
/*to solve this question we'll use dfs recursive to visit its neighbours when ever we 
see a land 1 , when ever we see 0 we do nothing 
time is O(N * M) ans space is O(N) */

class Solution {
    public int numIslands(char[][] grid) {
        
        if(grid == null || grid.length == 0) return 0;
        int islandCount = 0;
        
        int rowlength = grid.length;
        int colLength = grid[0].length;
        boolean[][] visited = new boolean[rowlength][colLength];
        
        for(int i = 0; i < rowlength; i++){
            for(int j = 0; j < colLength; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(grid, visited, i, j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }
    
     public void dfs(char[][] grid, boolean visited[][], int i, int j){
         
         if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] == true || grid[i][j] == '0')
             return;
         
         visited[i][j] = true;
         dfs(grid, visited, i - 1, j);
          dfs(grid, visited, i + 1, j);
          dfs(grid, visited, i, j - 1);
          dfs(grid,visited, i, j + 1);
         
     }
}