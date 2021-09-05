/*
another way of solving this problem is by using 2 hash set
1 for adding array 1 elelments into it and another for keeping the 
elements if they are thesame then we return the array
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> set = new HashSet<>();
        for(int n : nums1){
            set.add(n);
        }
        
        Set<Integer> intersect = new HashSet<>();
        for(int i : nums2){
            if(set.contains(i)){
                intersect.add(i);
            }
        }
        
        int[] result = new int[intersect.size()];
        int idx =0;
        
        for(int j : intersect){
            result[idx] = j;
            idx++;
        }
        return result;
    }
}