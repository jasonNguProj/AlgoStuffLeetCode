/*

similar to getting subsset question where an empty set is a subset, but now 
the input has duplicate so we will traverse via the emty list neighbors gor deep
and then bactrack back to our empty list to visit the other nums in the array list



*/


class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(result, new ArrayList<>(), 0, nums);
        return result;
    }
    
    public void dfs(List<List<Integer>> result, List<Integer> current, int start, int[] nums){
        
        result.add(new ArrayList<>(current));
        
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]) continue;
            current.add(nums[i]);
            dfs(result, current, i + 1, nums);
            current.remove(current.size() - 1);
        }
    }
}