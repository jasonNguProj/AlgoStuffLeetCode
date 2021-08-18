/*
we need to understand that the inputs 
in the matrix are only 1 or 0 and then 
wehen we traverse up, down , left , left and right diagonals
and sum them up as curr we can eventually get our answers
following the instructions.
so we will do 2 fxs, 1 for creting boundaries and the origial fxn 
for implementing instructions



*/


class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) 
		            return;
        int[][] result = new int[board.length][board[0].length];
        
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++){
                
                int current = 0;
                current = boandaries(board, i-1, j) + boandaries(board, i+1, j) + boandaries(board, i, j - 1) + 
                    boandaries(board, i, j+1) + boandaries(board, i-1, j - 1) + boandaries(board, i-1, j + 1) + 
                    boandaries(board, i + 1, j - 1) + boandaries(board, i + 1, j + 1);
                
                if(board[i][j] == 1){
                    if(current < 2){
                        result[i][j] = 0;
                    } else if(current == 2 || current == 3){
                        result[i][j] = 1;
                    } else if (current > 3){
                        result[i][j] = 0;
                    }
                } else{
                    if(current == 3){
                       result[i][j] = 1; 
                    }
                }
                    
            }
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = result[i][j];
            }
        }
    }
    
    public int boandaries(int[][] board, int i, int j){
        if(i >= 0 && i < board.length && j >= 0 && j < board[0].length)
            return board[i][j];
        return 0;
    }
}