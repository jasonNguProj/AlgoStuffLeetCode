/*
to solve this problem we will put a ptr on bith arrays starting nums
and move the pointers when ever we found that the values in that pointer 
is equal we add it into our array 

*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
         Arrays.sort(nums1);
        Arrays.sort(nums2);
        
       Set<Integer> result = new HashSet<>();
        
        int idxOne = 0, idxTwo = 0;
        
       
        while (idxOne < nums1.length && idxTwo < nums2.length){
            
            if(nums1[idxOne] == nums2[idxTwo]){
                result.add(nums1[idxOne]);
                idxOne++;
                idxTwo++;
            } else if (nums1[idxOne] > nums2[idxTwo]){
                idxTwo++;
            } else if (nums1[idxOne] < nums2[idxTwo]){
                idxOne++;
        }
    }
        int[] intersect = new int[result.size()];
        
        int idx =0;
        for(int num : result){
            intersect[idx] = num;
            idx++;
        }
       
        
        return intersect;
    }
}