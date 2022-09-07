
/*
solving via tabulation
we need an dp array plus 1 , we need to save the base case
then set the so fib of 0 is 0
then we fill up the array with the first values and then
fill up the rest with the fib formul which the sum of previous 2 numbers
O(N) time and space


solving via memoization 
where we start form top and then go down 
we first have our base case since memoization includes recursion

we use a map to store the first two fib
then we check if our map contains the fib , if it doens we 
compute the fib and add as value, or cache into our map
then we just return our fib value which essentially the value in our map

*/



class Solution {
    public int fib(int n) {
        
       // base case
        
        if (n < 2) return n;
        
        
        // cache some values we already know, so basically sub problems
        //we use a hMap for these 
        Map<Integer, Integer> map = new HashMap<>(Map.of(0, 0, 1, 1));
        
        
        // then we check our map if we do have the cached value
        //if we do we just return the value from our map
        //if not we return the cached value
        
        if(!map.containsKey(n)){
            
            int fibValue = fib(n-1) + fib(n-2);
            map.put(n, fibValue);
        }
        return map.get(n);
        
//         if(n == 0) return 0;
        
//         int[] dp = new int[n + 1];
        
//         dp[0] = 0;
//         dp[1] = 1;
        
//         for(int i = 2; i <= n; i++){
//             dp[i] = dp[i - 1] + dp[i -2];
//         }
        
//         return dp[n];
    }
}