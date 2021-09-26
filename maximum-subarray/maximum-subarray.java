/*

to solve this question we need to understand that
its a kadane type problem where we keep track of the 
curr and max nums in the array as curr vals
and update the current to be the greater value btw our curr and 
sum of our curr and present num
and then update our max from our max and curr and then in the end return max 

*/

class Solution {
    public int maxSubArray(int[] nums) {
        
        int start = nums[0], largest = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            start = Math.max(nums[i], nums[i] + start);
            largest = Math.max(start, largest);
        }
        
        return largest;
        
    }
}