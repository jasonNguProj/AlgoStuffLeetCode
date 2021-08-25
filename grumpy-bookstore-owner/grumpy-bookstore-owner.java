class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
         int satisfiedCustomer = 0;

    int l = 0, r =0;
    int maxUnSatisfiedCustomer = 0;
    int unSatisfiedCustomer = 0;
    
    
    while(r < grumpy.length){
        
        if(grumpy[r] == 1){
            unSatisfiedCustomer += customers[r];
        }else {
            satisfiedCustomer += customers[r];
        }
        
        if(r - l + 1 > minutes){
            if(grumpy[l] == 1){
                 unSatisfiedCustomer -= customers[l];
             }
            l++;
        }
        
        maxUnSatisfiedCustomer = Math.max(maxUnSatisfiedCustomer, unSatisfiedCustomer);
        r++;
    }
    
    
   return satisfiedCustomer + maxUnSatisfiedCustomer;
    }
}