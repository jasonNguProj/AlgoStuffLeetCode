/*
for this question we will keep moving our boundaries inwards

*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        ArrayList<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length ==0) return res;
        
        int rowBegin =0, rowEnd = matrix.length - 1, colBegin = 0, colEnd = matrix[0].length - 1;
        // right
        while(rowBegin <= rowEnd && colBegin <= colEnd){
            
            for(int i = colBegin; i <= colEnd; i++){
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;
        
        //down
        for(int i = rowBegin; i <= rowEnd; i++){
            res.add(matrix[i][colEnd]);
                 }
            colEnd--;
            
            //left
            if(rowBegin <= rowEnd){
                for(int i = colEnd; i >= colBegin; i--){
                    res.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }
            
            //up
             if(colBegin <= colEnd){
                for(int i = rowEnd; i >= rowBegin; i--){
                    res.add(matrix[i][colBegin]);
                }
                colBegin++;
            }
        }
        
        return res;
    }
}