
/*
traverse and put nums in a hashMap when ever we find our potential match in the hmap 
we return that index of the index 
else we just add num to the map
O(N) Space- Time complexity because you traverse the entire array and use the hmap for 
extra space
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0; i < nums.length; i++){
            int potentialMatch = target - nums[i];
            
            if(map.containsKey(potentialMatch)){
                return new int[] {map.get(potentialMatch), i};
            } else {
                map.put(nums[i], i);
            }
        }
        
        return new int[] {-1, -1};
    }
}