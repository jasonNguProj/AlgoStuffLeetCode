/*

to solve this problem we are going to use sieve of erasthotenes
so 3 steps we have a boolean array 
we traverse from 2 the first prime
then set its square to true 
then we traverse to count the ones that are still false
*/

class Solution {
    public int countPrimes(int n) {
        
        boolean[] sqNum = new boolean[n];
        for(int i = 0; i <sqNum.length; i++){
            sqNum[i] = true;
        }
        
        for(int i = 2; i * i < sqNum.length; i++){
            if(sqNum[i] == true){
                for(int j = 2; i * j < n ; j++){
                    sqNum[i * j] = false;
                }
            }
        }
        
        int countPrime = 0;
        for(int i = 2; i <sqNum.length; i++){
            if(sqNum[i] == true){
                countPrime++;
            }
        }
        
        return countPrime;
    }
}