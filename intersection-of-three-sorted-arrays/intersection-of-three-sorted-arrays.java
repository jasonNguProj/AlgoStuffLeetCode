/*

since the array is sorted we can solve this qxn with three ponters
for array 1, 2 and 3, and manipulate them

*/

class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        
        int idx = 0, idxOne = 0, idxTwo = 0;
        
        List<Integer> result = new ArrayList<>();
        while(idx < arr1.length && idxOne < arr2.length && idxTwo < arr3.length){  
            if(arr1[idx] == arr2[idxOne] && arr2[idxOne] == arr3[idxTwo]){
                result.add(arr1[idx]);
                idx++;
                idxOne++;
                idxTwo++;    
            }
            else if(arr1[idx] < arr2[idxOne]) {
                idx++;
            }   else if(arr2[idxOne] < arr3[idxTwo]) {
                idxOne++;
            } else{
                idxTwo++;
            }
        }
        return result;
        
    }
}