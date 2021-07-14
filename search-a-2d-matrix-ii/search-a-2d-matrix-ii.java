// since the grid is sorted in ascending top down and descending left to right
// we will set two pointers one at end of row and one at starting col
// so if grid value is greater than target we decrement row--
//if value is less than target we increment col++

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = matrix.length - 1;
        int col = 0;
        
        while (row >= 0 && col < matrix[0].length){
            if(matrix[row][col] > target){
                row--;
            } else if(matrix[row][col] < target){
                col++;
            }else {
                return true;
            }
        }
        return false;
    }
    
}