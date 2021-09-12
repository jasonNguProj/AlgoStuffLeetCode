/*
to solve this question we will traverse via 
dfs recursion preorder , where we go deep and traverse 
and then back track to explore the new numbers



*/


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        dfs(res, new ArrayList<>(), 0, nums);
        
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> subsets, int start, int[] nums){
        
         res.add(new ArrayList<>(subsets));
        for(int i = start; i < nums.length; i++){
            subsets.add(nums[i]);
            dfs(res, subsets, i + 1, nums);
            subsets.remove(subsets.size() - 1);
        }
        
        
        
    }
}