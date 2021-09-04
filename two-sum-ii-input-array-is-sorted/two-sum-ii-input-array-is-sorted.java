/*
to solve this problem we'll use 2 ptr approach
wehn ever the vals is greater than target we decre end when its smaller we increment  start
O(N) time | O(1) space

*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int start = 0;
        int end = numbers.length - 1;
        
        while(start < end){
            int potentialSum = numbers[start] + numbers[end];
            
            if(potentialSum == target){
                return new int[] {start + 1, end + 1};
            } else if(potentialSum > target){
                end--;
            } else if (potentialSum < target){
            start++;
        }
            
    }
return new int[]{-1, -1};
  }
}