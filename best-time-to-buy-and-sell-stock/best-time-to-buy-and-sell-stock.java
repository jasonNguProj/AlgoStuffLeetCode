/*to solve this problem we will use kadanse algo in one pass
where we reset our curMax to 0 when ever we get a negative value
and then keep track of overall max value and then return that value
then time is O(N) | Space is O(1) */

class Solution {
    public int maxProfit(int[] prices) {
        
        int curMax = 0;
        int max = 0;
        
        for(int i = 1; i < prices.length; i++){
            curMax = Math.max(0, curMax += prices[i] - prices[i - 1]);
            max = Math.max(curMax, max);
        }
        return max;
    }
}