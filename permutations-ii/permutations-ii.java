// we'll use recursion n backtacking to backtrack whenever we want a unique permutation
// time comp O(N *N!) space (O(N * N!))
// for duplicates to avoid indexout of bnds exception we want to check if next nad prev elements in nums are same


class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        
        List<Integer> permutations = new ArrayList<>();
        
        computePermutations(result, permutations, nums, new boolean[nums.length]);
        
        return result;
        
    }
    
    private void  computePermutations(List<List<Integer>> result, List<Integer> permutations, int[] nums, boolean [] used){
        if (nums.length == permutations.size()) 
            result.add(new ArrayList<>(permutations));
        else{
            for (int i = 0; i < nums.length; i++){
                if (used[i] == true) continue;
                if (i > 0 && nums[i] == nums[i - 1] && used[i -1] == false) continue;
                 permutations.add(nums[i]);
                used[i]= true;
                computePermutations(result, permutations, nums, used);
                used[i] = false;
                permutations.remove(permutations.size() - 1);
            }
        }
    }
}