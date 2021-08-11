/*


to solve this problem we will begin adding from the back
so we will need 3 pointers p1 for arr 1 , p2 for arr 3
and p for the place we will update in the big array
and we will terminate when p2 is done 



*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
         int idxOne = m -1, idxTwo = n -1, idxUpdate = m + n -1;
          while (idxTwo >=0){
            if(idxOne >=0 && nums1[idxOne] > nums2[idxTwo]){
                nums1[idxUpdate--] = nums1[idxOne--];
            }else{
                nums1[idxUpdate--] = nums2[idxTwo--];
            }
        }
        
//         int p1 = m -1, p2 = n - 1, p = m + n -1;
        
//         while(p2 >= 0){
//             if(p1 >= 0 && nums1[p1] < nums2[p2]){
//                 nums1[p--] = nums2[p2--];
//             }else {
//                   nums1[p--] = nums1[p1--];
//             }
//         }
    }
}