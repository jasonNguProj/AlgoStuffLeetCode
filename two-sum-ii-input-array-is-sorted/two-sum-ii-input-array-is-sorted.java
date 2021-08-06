class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
//          Map<Integer, Integer> map = new HashMap<>();
        
//         for(int i = 1; i <= numbers.length-1; i++){
//             int potentialMatch = target - numbers[i];
//             if(map.containsKey(potentialMatch)){
//                 return new int[] {map.get(potentialMatch), i};
//             }else {
//                 map.put(numbers[i], i);
//             }
//         }
//         return new int[] {-1, -1};
        
        int start = 0, end = numbers.length - 1;
        while(start <= end){
            int potentialSum = numbers[start] + numbers[end]; 
            if(potentialSum == target){
                return new int[] {start + 1, end + 1};
            } else if (potentialSum > target){
                end--;
            }else{
                start++;
            }
        }
        return new int[]{-1, -1};
        
    }
}