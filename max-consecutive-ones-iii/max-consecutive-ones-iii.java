
/*
to solve this problem we have to maintian a window
of k number of zeoes by the time the nums zeroes 
is greater than k then we reduce the number of zeroes and
shrink the window as well

*/

class Solution {
    public int longestOnes(int[] nums, int k) {
        int start =0, end =0, maxLen = 0, zeroCount = 0;
        
        while(end < nums.length){
            if(nums[end] == 0) zeroCount++;
            
            if(zeroCount > k){
                if(nums[start] == 0){
                    zeroCount--;
                }
                start++;
            }
            
            maxLen = Math.max(end - start + 1, maxLen);
            end++;
        }
        return maxLen;
        
    }
}