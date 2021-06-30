class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        
        backTrack(result, tempList, 0, target, candidates);
        
        return result;
    }
    
    
    public void backTrack(List<List<Integer>> result, List<Integer> tempList, int start, int target, int[] candidates){
        if (target < 0) return;
         if(target == 0) result.add(new ArrayList<>(tempList));
        
            for(int i = start; i < candidates.length; i++){
            tempList.add(candidates[i]);
            backTrack(result, tempList, i, target - candidates[i], candidates);
            tempList.remove(tempList.size() - 1);
        }
        
    }
}