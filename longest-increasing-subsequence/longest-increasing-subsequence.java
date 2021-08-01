/*

10,9,2,5,3,7,101,18
2,3,5,7,9,10,18,101
   
   7
10 5  101
9  3    18
   2
*/


class Solution {
    public int lengthOfLIS (int[] nums) {
    TreeSet<Integer> set = new TreeSet<>();
    for(int i : nums) {
        Integer ceil = set.ceiling(i);
        if(null != ceil) {
            set.remove(ceil);
        }
        set.add(i);
    }
    return set.size();
}
}