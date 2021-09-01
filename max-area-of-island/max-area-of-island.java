
/*


to solve this qxn well traverse dfs recursion in a preorder manner 
when ever we see a 1 we traverse in all 4 directions 
*/

class Solution {
    int max, currMax = 0;
    public int maxAreaOfIsland(int[][] grid) {
    
        int row = grid.length;
        int col = grid[0].length;
        
        boolean[][] visited = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if( grid[i][j] == 1 && !visited[i][j]){
                    currMax = 0;
                    dfs(grid, i, j, visited);
                } 
            }
        }
        
        return max;
    }
    
    
   private void dfs(int[][] grid, int i, int j,  boolean[][] visited ){
       
       if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]){
           return;
       }
       
       visited[i][j] = true;
       currMax++;
       
       dfs(grid, i + 1, j, visited);
        dfs(grid, i - 1, j, visited);
        dfs(grid, i, j + 1, visited);
        dfs(grid, i, j - 1, visited);
       
       max = Math.max(max, currMax);
   }
}