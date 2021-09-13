/*
similar to subsets, but we notice that the permutaions
are of size 3, so we have to find a way to traverse and 

*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        boolean[] seen = new boolean[nums.length];
        
        dfs(res, new ArrayList<>(), nums, seen);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> current, int[] nums, boolean[] seen){
        
        if(current.size() == nums.length){
            res.add(new ArrayList<>(current));
            return;
        }
        for(int i = 0; i < nums.length; i++){
             if( seen[i])continue;
            current.add(nums[i]);
            seen[i] = true;
            dfs(res, current, nums, seen);
            current.remove(current.size() - 1);
            seen[i]= false;
        }
        
        
        
    }
}