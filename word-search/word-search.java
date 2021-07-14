
// so basically we traverse the board in a dfs recursive manner and check if the xter is present
// if the xter is present in both the board and word we continue else we backtrack and set the xtre to unseen for //subsequent traverse
// if the endIdx == word.length then we have reached the end of word and we have all words present
//so we return true
//we have to makesure we traverse within the boundaries
// when we traverse a cell we set to true 
// then we call the recursive soln in 4 dir top, down, left
//we backtrack if when we are traversing through the board and the next xter does not match that of word xtre 
//we bactrack to another or prev cell and set that seen cell unseen for next traversal
// time comp : O(N *(M + L)) L is the xter in word, space is  O(n) the height of the recursive call stack

class Solution {
    public boolean exist(char[][] board, String word) {

        for(int i = 0; i < board.length; i++){
            for(int j =0; j < board[0].length; j++){
                if(dfs(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }
    
    
    public boolean dfs(char[][] board, int i, int j, String word, int wrdIdx){
    
    if(wrdIdx == word.length()) return true;
    
    if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != word.charAt(wrdIdx)){
        return false;
    }
    char temp = board[i][j];
    board[i][j] = '0';
    if( dfs(board, i - 1, j, word, wrdIdx + 1)
        || dfs(board, i +1, j, word, wrdIdx + 1)
          || dfs(board, i, j + 1, word, wrdIdx + 1)
            || dfs(board, i, j - 1, word, wrdIdx + 1)) {
        return true;
    } 
    
    board[i][j] = temp;
    
    return false;
    
        }
}

