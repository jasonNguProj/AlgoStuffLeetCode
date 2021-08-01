/*
we'll traverse tha array and input into the hashmap
potential sume is num[i] + target
so if map contains potential sum we return indices
else we add into hashmap
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int potentialMatch = target - nums[i];
            if(map.containsKey(potentialMatch)){
                return new int[]{map.get(potentialMatch), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}