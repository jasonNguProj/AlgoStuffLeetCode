/*
to solve this problem we need 3 pointers
that we will keep manipulating as we traverse the array
and then add into a result list, and at the end return our result
O(N ^ 2) Time | O(N) space 

*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {     
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        if (nums.length == 0 || nums == null) return new ArrayList<>(result);
        for(int i = 0; i < nums.length - 2; i++){
            int start = i + 1, end = nums.length - 1;
            while(start < end){
                int tripletSum = nums[i] + nums[start] + nums[end];
                if(tripletSum == 0){
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                } else if(tripletSum > 0){
                    end--;
                }else if(tripletSum < 0){
                    start++;
                }
            }
        }
        return new ArrayList<>(result);
    }
}