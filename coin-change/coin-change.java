/*
to solve this question we need to understand the lingo, 
they are asking for min num of coins, so whenever we get min, max 
number of something that should be a hint that we need to use dynamic programming
so to solve this problem we will use bottom up approach
where we initialize an array of size amount and fill it up wh
amt + 1 which in essence will be the max number available
so that it will help us as we look for min
so the first ro will be equal to 0 because given 0 coin we can hve 0 amt
and so to calculate the min 
we traverse via our dp array starting from 1 and also traverse via our coins
if our i is less than our coin value no need to proceed 
so to populate our dp is the min of our present dp value and cointi - dp + 1
so we are told in the question that if the coins cnt make up the amt we return -1



*/


class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
         dp[0] = 0;
        
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(i >= coins[j]){
                      dp[i] = Math.min(dp[i] , 1 + dp[i - coins[j]]);
                }
              
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
}