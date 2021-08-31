/*
to solve this question we need to underand that when matrix 
is 0 and on the border we cant flip it to an x, we can only flip 0 when its not in the border
or connected to an x in the border so we willl solve this question
recursively via dfs traversing the rows and cols for searching for 0 and storing them in a temp variable p
then checking the matrix again when 0 flip to x and when p flip to 0

time complexity is O(N * M ) | space is  O( N * M) because of height of recursive stack


*/

class Solution {
    
    public void solve(char[][] board) {
		if (board.length == 0 || board[0].length == 0) return;
		int m = board.length;
		int n = board[0].length;

		// go through the first column and the last column
		for (int i = 0; i < m; i++) {
			dfs(board, i, 0);
			dfs(board, i, n - 1);	
		}

		// go through the first row and the last row
		for (int j = 1; j < n - 1; j++) {
			dfs(board, 0, j);
			dfs(board, m - 1, j);	
		}

                // make all the remaining 'O' to 'X'
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') board[i][j] = 'X';
                                if (board[i][j] == '*') board[i][j] = 'O';
			}
		}
	}


	// make every 'O' that we meet to '*' 
        // It is safe because we always start from the border
	private void dfs(char[][] board, int i, int j) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
		if (board[i][j] == 'X' || board[i][j] == '*') return;
		board[i][j] = '*';
		dfs(board, i - 1, j);
		dfs(board, i + 1, j);
		dfs(board, i, j - 1);
		dfs(board, i, j + 1);
	}
    //public void solve(char[][] grid) {
        
        
        
//         if(grid[0].length == 0  || grid.length == 0) return;
        
//         int row = grid.length;
//         int col = grid[0].length;
        
        
//           for(int j = 0; j < col; j++){
//                 dfs(grid, j, 0);
//                 dfs(grid,j, col -1);
            
//         }
        
//         for(int i = 1; i < row - 1; i++){
//                 dfs(grid, 0, i);
//                 dfs(grid, row -1, i);
            
//         } 
        
//         for(int i = 0; i < grid.length; i++){
//             for(int j = 0; j < grid[0].length; j++){
//                 if(grid[i][j] == 'O'){
//                     grid[i][j] = 'X';
//                 }
//                else  if(grid[i][j] == 'p'){
//                     grid[i][j] = 'O';
//                 }
//             }
//         }
//     }
    
    
//     public void dfs(char[][] board, int i, int j){
         
//         if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
//         if(board[i][j] == 'X' || board[i][j] == 'p') return;
        
//         board[i][j] = 'p';
//         dfs(board, i + 1, j);
//          dfs(board, i , j+ 1);
//          dfs(board, i - 1, j);
//          dfs(board, i, j - 1);
        
      
//     }
}