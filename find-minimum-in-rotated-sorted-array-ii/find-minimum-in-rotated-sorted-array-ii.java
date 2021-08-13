/*

to solve this problem this is a variation of bin search with a couple
of diff 
so since there will be duplicates there are 3 things to check
first if high is gretaer than mid
we just put high in min because the element will be found below the mid
also if mid is greter than high ofcourse we bring our low cursor 
to be mid + 1 cus the lement will be in the upper bound
now when mid is equal to high this is the case where we need to essentially 
take care of in the algo as at this point we dont know where to move we just
shrink the high -1, to avoid endless lopp, to protect our prog some stagnating


*/


class Solution {
    public int findMin(int[] nums) {
        
        int start = 0, end = nums.length -1;
        while(start < end){
            int mid = start + (end - start)/ 2;
            if(nums[mid] > nums[end]){
                start = mid + 1;
            } else if(nums[end] > nums[mid]){
                end = mid;
            } else{
                end--;
            }
        }
        return nums[start];
        
    }
}