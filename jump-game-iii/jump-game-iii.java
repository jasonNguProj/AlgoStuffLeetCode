/*
   0 1 2 3 4 5 6
  [4,2,3,0,3,1,2]
  
*/

class Solution {
    public boolean canReach(int[] arr, int start) {
        if(start < 0 || start >= arr.length || arr[start] < 0)
	            return false;
	        arr[start] *= -1;
	        return arr[start] == 0 || canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
    }
}