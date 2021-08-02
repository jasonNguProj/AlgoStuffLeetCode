/*
to solve this question we need a hash map and match 
match = target - arri, if match present in hashmap get the value
else add into hashmap


*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int potentialMatch = target - nums[i];
            if(map.containsKey(potentialMatch)){
                return new int[] {map.get(potentialMatch), i};
            }else {
                map.put(nums[i], i);
            }
        }
        return new int[] {-1, -1};
    }
}