/*
to solve this problem we will use sliding the indow teknik
where our k will be the sum of 1's then we will remove or add
by the time our sum is greter than our window then we substract the start

*/

class Solution {
    public int minSwaps(int[] data) {
        
        int sum = 0;
        for(int num : data)
            sum += num;
        
        
        int start = 0, end = 0, minSwap = 0, currWin = 0; 
        
        while(end < data.length){
            minSwap += data[end];
            if(end - start + 1> sum){
                minSwap -= data[start];
                start++;
            }
            currWin = Math.max(minSwap, currWin);
            end++;
        }
        return sum - currWin;
        
    }
}