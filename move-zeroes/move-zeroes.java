/*
to solve this question we will use 
one pointer to add numbers in the
that are not zero, then when finish placing those
we add 0 to the ones at the end

*/

class Solution {
    public void moveZeroes(int[] nums) {
        
        int idx = 0;
        
        for(int num : nums){
            if(num != 0){
                nums[idx++] = num;
            }
        }
        
        while(idx < nums.length){
            nums[idx++] = 0;
        }
        
    }
}