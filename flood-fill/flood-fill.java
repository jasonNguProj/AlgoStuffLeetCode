/*
to solve this question we need to understand that we are given
old color as ones to flip them to new color as 2
so we'll solve this recursively following dfs post order
and note that we only flip to new color only if the color is 1
we dnt flip 0 and we go in 4 directions and so we cnt flip the 1 at
bottom left since its diagonal
time is O(N) because we will have to travel via all pixels and 
space is o(n) because of the recursive stack

*/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image[sr][sc] == newColor) return image;
         dfs(image, sr , sc, image[sr][sc], newColor);
        return image;
    }
    
    public void dfs(int[][] image, int sr, int sc,int oldColor, int newColor) {
        
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor)
            return;
        
        image[sr][sc] = newColor;
        dfs(image, sr - 1, sc, oldColor, newColor);
        dfs(image, sr + 1, sc, oldColor, newColor);
        dfs(image, sr, sc - 1, oldColor, newColor);
        dfs(image, sr, sc + 1, oldColor, newColor);
        
        
    }
}