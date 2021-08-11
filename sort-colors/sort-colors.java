
/*
to solvethis problem i will create a swap fxn 
that will swap when not in place 


*/

class Solution {
    public void sortColors(int[] nums) {
        
       int zeroIndex = 0, twoIndex = nums.length - 1, i = 0;
        
        while(i <= twoIndex){
            if (nums[i] == 0) swap(nums, i++, zeroIndex++);
            else if(nums[i] == 2) swap(nums, i, twoIndex--);
            else i++;
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}