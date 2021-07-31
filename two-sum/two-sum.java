/*
to solve this problem 
we traverse via array and and check 
target = arr[i] + arr[j] 
which implies aar[i] = target - aff[j]
so if we find arr[i] in hmap we just retunr the index else we add into our hashmap

*/


class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
           int potentialMatch = target - nums[i];
            if(map.containsKey(potentialMatch)){
                return new int[] {map.get(potentialMatch), i};
            } else{
                map.put(nums[i], i);
            }
        }
        return new int[] {-1, -1};
    }
}