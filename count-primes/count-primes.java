/*

to solve this problem we are going to use sieve of erasthotenes
so 3 steps we have a boolean array 
we traverse from 2 the first prime
then set its square to true 
then we traverse to count the ones that are still false
this takes O(N) space | O(loglog n)
*/

class Solution {
    public int countPrimes(int n) {
        
        boolean[] sqNum = new boolean[n];
        // for(int i = 0; i <sqNum.length; i++){
        //     sqNum[i] = true;
        // }
        Arrays.fill(sqNum, true);
        
        for(int i = 2; i * i < n; i++){
            if(sqNum[i]){
                for(int j = 2; i * j < n ; j++){
                    sqNum[i * j] = false;
                }
            }
        }
        
        int countPrime = 0;
        for(int i = 2; i <n; i++){
            if(sqNum[i]){
                countPrime++;
            }
        }
        
        return countPrime;
    }
}