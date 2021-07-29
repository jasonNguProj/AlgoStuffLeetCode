/*

so basically we use sliding the window tecknic
first we sum all the nums in the array as my window
and have a left and right ptr
we move the right ptr along as we grow the window
whenever r -l > window size
we shrinck the left
int the end the it will be window size - maxOnes sofar


*/

class Solution {
    public int minSwaps(int[] data) {
        
        int windowSize = 0;
        for(int i = 0; i < data.length; i++){
            windowSize += data[i];
        }
        
        int start = 0, end = 0, max =0, maxSofar = 0;
        
        while(end < data.length){
            max += data[end++];
            if(end - start > windowSize)
            {
               max -= data[start++];
            }
            
            maxSofar = Math.max(max, maxSofar);
        }
        
        return windowSize - maxSofar;
    }
    
    
}