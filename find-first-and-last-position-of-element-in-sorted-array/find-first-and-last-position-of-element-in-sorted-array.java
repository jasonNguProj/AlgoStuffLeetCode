/*
to solve this probllem we will do a binary search from the start
where we do midVal >=target and then from the end we do target > midval
if midval == target we update our index
index was initialized to -1
time is O(log n) and space is O(1) becasue we will always return 2 elements in the array
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
      int[] result = new int[2];
        result[0] = computeFirst(0, nums.length - 1, nums,  target);
        result[1] = computeSecond(0, nums.length - 1, nums,  target);
        return result;
    }
    
    public int computeFirst(int start, int end, int[] nums, int target){
        int index = -1;
          while (start <= end){
            int middle = start + (end-start)/2;
            int midVal = nums[middle];
            if(target <= midVal){
                end = middle - 1;
            } else {
                start = middle + 1;
            } 
                if(target == midVal){
                index = middle;
            }
        }
        
        return index;
    }
    
    public int computeSecond(int start, int end, int[] nums, int target){
        int index = -1;
          while (start <= end){
            int middle = start + (end-start)/2;
            int midVal = nums[middle];
            if(target >= midVal){
                start = middle + 1;  
            } else{
                end = middle - 1;
            } 
              if(target == midVal){
                index = middle;
            }
        }
        
        return index;
    }
}