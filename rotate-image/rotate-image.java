// frist we transpose meaning the  row will become the col
// the col become row
// invert by going upto n/ 2 bound and swap inward because if we set bound past that 
// it will revert to original state
// class Solution {
//     public void rotate(int[][] matrix) {
        
//         for(int i = 0; i < matrix.length; i++){
//             for(int j = 0; j < matrix[i].length; j++){
//                 int temp = matrix[i][j];
//                 matrix[i][j] = matrix[j][i];
//                 matrix[j][i] = temp;
//             }
//         }
        
//         for(int i = 0; i < matrix.length; i++){
//             for(int j = 0; j < matrix.length/2; j++){
//                 int temp = matrix[i][j];
//                 matrix[i][j] = matrix[i][matrix.length -1 -j];
//                 matrix[i][matrix.length -1 -j] = temp;
                
//             }
//         }
        
//     }
// }


public class Solution {
    public void rotate(int[][] matrix) {
        for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[i].length; j++){
               // int temp = 0;
               int  temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i =0 ; i<matrix.length; i++){
            for(int j = 0; j<matrix[i].length/2; j++){
               // int temp = 0;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
}