/*to solve this problem we add all elements in a set 
we traverse via the set and check if n - 1 is present 
which of course is not present then we do 
int m = n + 1, and check while m is prent int the set
if it is present int the we increment m
then update best to be m - n then at the end return best
space is O(N)| time is O(1)




*/

class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        
        int best = 0;
        for(int n : set){
            if(!set.contains(n -1)){
                int m = n + 1;
                while(set.contains(m)){
                    m++;
                }
                best = Math.max(best, m - n);
            }
        }
        return best;
    }
}