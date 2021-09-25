class Solution {
    public int maxProfit(int[] prices) {
        
        int current =0, maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            current = Math.max(0, current += prices[i] - prices[i - 1]);
            maxProfit = Math.max(current, maxProfit);
        }
        
        return maxProfit;
    }
}