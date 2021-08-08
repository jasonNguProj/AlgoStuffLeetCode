/*
to solve this problem we will utilise kadanes
and always keep track of max so we take the bigger btw 2 vals and continue and in the end
return our bimax
O(N) Time | O(1) Space


*/

class Solution {
    public int maxSubArray(int[] nums) {
        
        int currMax =nums[0];
        int bigMax = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            int val = nums[i];
            currMax = Math.max(val, currMax + val);
            bigMax = Math.max(currMax, bigMax);
        }
        return bigMax;
    }
}