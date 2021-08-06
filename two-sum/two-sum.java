class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            int potentialMatch = target - nums[i];
            if(map.containsKey(potentialMatch)){
                return new int[] {map.get(potentialMatch), i};
            }else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}