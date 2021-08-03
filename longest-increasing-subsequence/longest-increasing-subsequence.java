/*
to solve this question we will use a treeset 
and use ceiling method that comes with treeset which gives smallest max of our present val
so if ceiling which is max not null we remove that value 
then add our present value.
time comp is O(n log n) time | O(N) space 

*/


class Solution {
    public int lengthOfLIS(int[] nums) {
        
        TreeSet<Integer> set = new TreeSet<>();
        
        for(int num : nums){
            Integer nextMax = set.ceiling(num);
                if(nextMax != null){
                    set.remove(nextMax);
                }
            set.add(num);
        }
        return set.size();
    }
}