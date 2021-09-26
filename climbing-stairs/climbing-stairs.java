/*
to solve this question we need to understand that its
a fibbonnaci variation question given that if n = 1 we return 1
and if nis 2 we return 2 so we will be solving it same way we do with fibonacci number


*/


class Solution {
    public int climbStairs(int n) {
        
        
        if(n == 1) return 1;
        
        int firstNum = 1, secNum = 2;
        
        for(int i = 3; i <= n ; i++){
            int thirdNum = firstNum + secNum;
            firstNum = secNum;
            secNum = thirdNum;    
        }
        return  n > 1 ?  secNum : 1;
    }
}