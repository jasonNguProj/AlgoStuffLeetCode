
/*

we need an dp array plus 1 , we need to save the base case
then set the so fib of 0 is 0
then we fill up the array with the first values and then
fill up the rest with the fib formul which the sum of previous 2 numbers
O(N) time and space


*/



class Solution {
    public int fib(int n) {
        
        if(n == 0) return 0;
        
        int[] dp = new int[n + 1];
        
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i -2];
        }
        
        return dp[n];
    }
}