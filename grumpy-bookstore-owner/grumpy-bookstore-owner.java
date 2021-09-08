/*
to break this problem down we need to understand to maintains a window of
size minutes, then tke note of the grumpy and non grumpy
then we calculate the max grumpy
the max cust satisfied will essentially be the satisfied cust plus the 
non satisfied customers

*/

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int start =0, end =0, maxUnsatified =0, satified = 0, unsatified = 0;
        
        while(end < customers.length){
            if(grumpy[end] == 1) {
                unsatified += customers[end];
            } else {
                satified += customers[end];
            }
            
            if(end - start + 1 > minutes) {
                if(grumpy[start] == 1) {
                unsatified -= customers[start];
            }
                start++;
        }
            maxUnsatified = Math.max(unsatified, maxUnsatified);
        end++;
    }
        
        /*
        we do satisfied  + max unsatified because we are told in the question that the shop owner 
        has a teknik of keeping himself not grumpy for 3 minutes , so inorder to find the max cust satisfied
        firstly we calculate the satisfied cust when not grumpy which is when 
       grumpy is equal to 0 , cust =[1,0,1,2,1,1,7,5] from when grumpy is equal 0 , the satisfied is 1 + 1 + 1 + 7 = 10, ie infor from the grumpy array
                              grump=[0,1,0,1,0,1,0,1],                             when mapping them to values in the cust array
    then since we are told the shop guy can keep himself not grumpy for 3 mins, then we need to find a running max of non grumpy in a 3 min window
    that when grummpy is 1 in a window of max 3, we keep updating our max and in the end add to our satisfied of 10, where the max unsatisfied window
    is the 3 window elements in the end where grumpy is equal to 1, which is 1 + 5 = 6 + 10(ungrumpy) = 16
        
        */
        
        return satified + maxUnsatified;
}
}