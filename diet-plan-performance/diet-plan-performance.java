/*
to solve this question we need to understand that 
its a sliding window variation with window k
so we need to form our end and start ptrs
at the begining we add our value
then when ever our window that is our end - start + 1 
is equal to k days or window then we remove from the array 
in end - start + 1, the + 1 is because arrays start counting from 0


*/

class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        
        int point =0, start = 0, end = 0, totalSum = 0;
        while(end < calories.length){
            totalSum += calories[end];
            if(end - start + 1 == k){
                if(totalSum > upper) point++;
                if(totalSum < lower) point--;  
                 totalSum -= calories[start]; 
                start++;
            }
            end++;
        }
        return point;
    }
}