/*
to solve this qxn we need to sort o, and 2 
and the end 1 wil be in its correct position

*/

class Solution {
    public void sortColors(int[] nums) {
        int start = 0, end = nums.length - 1, i =0;
        
        while(i <= end){
            if(nums[i] == 0) swap(nums, i++, start++);
           else if(nums[i] == 2) swap(nums, i, end--);
            else if(nums[i] == 1) i++;
        }    
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}