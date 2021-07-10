class Solution {
    // O(1) Space || O(N) time; 
    public int[][] flipAndInvertImage(int[][] image) {
        
        for (int i = 0; i <image.length; i++){
            int left =0;
            int right = image[i].length - 1;
            
            while(left <= right){
                if(image[i][left] == image[i][right]){
                    image[i][left] = 1 - image[i][left];
                    image[i][right] = image[i][left];
                }
                left++;
                right--;
            }
        }
        return image;
        
    }
}