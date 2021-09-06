/*
to solve this question we need to understand that the calculate the max area,
is to compute a running area and update the value untill we find a max
and to find area is heigh of min btw the big and small becuase in a container when we have the small and the big height 
the real height is where the short height reaches because the rest will fall off,
similarly we keep doing that and manipulating the pointers untill we get our big man 
time is O(N) cus we trav the entire array | and space is O(1) cus no extra space is used up


*/

class Solution {
    public int maxArea(int[] height) {
        
        int areaMax =Integer.MIN_VALUE, start = 0, end = height.length - 1;
        
        while(start < end){
            int area = Math.min(height[start], height[end]) * (Math.abs(start - end));
            areaMax = Math.max(areaMax, area);
            
            if(height[start] < height[end]){
                start++;
            } else{
                end--;
            }
        }
        return areaMax;
    }
}