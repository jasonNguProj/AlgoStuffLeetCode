/*
to solve this question we will need to start adding elements 
from the end of arr one and then decrements the indices from 
arr1 and arr2, and add into array if the  val at arr2 is greater than
the value at idx2 in arr1, and then we also need to check a case where 
there can be an element in arr2 smaller than an element in arr1

space O(1) | time O(M + N);

*/


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int idxOne = m - 1, idxTwo = n - 1, idxEnd = m + n - 1;
        
        while(idxOne  >= 0 && idxTwo >= 0){
            
            if(nums1[idxOne] >= nums2[idxTwo]){
                nums1[idxEnd--] = nums1[idxOne--];
            } else {
                nums1[idxEnd--] = nums2[idxTwo--];
            }
        }
        
        while (idxTwo >= 0){
             nums1[idxEnd--] = nums2[idxTwo--];
        }
        
    }
}