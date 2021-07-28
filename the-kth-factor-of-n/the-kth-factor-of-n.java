/*
so we create an array from n 
the use a minheap we poll untill k thwn return the peek 
the peek will be the k factor
*/

class Solution {
    
     public int kthFactor(int n, int k) {
        int cnt = 0;
        int ans = 0;
        
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                cnt++;
                ans = i;
            }
            
            if (cnt == k) return ans;
        }
        
        return -1;
    }
//  public int kthFactor(int n, int k) {
        
//      PriorityQueue<Integer> minHeap =  new PriorityQueue<>((e1, e2) -> e1 - e2);
//         int nums[] = new int[n];
//         for(int i = 1; i < n; i++){
//             int ans = n % i;
//             if(ans == 0){
//                 nums[i] =  i; 
//             }
//         }
     
//      for(int i = 0; i < k; i++){
//          minHeap.add(nums[i]);
//      }
     
     
//      for(int i = k; i < nums.length; i++){
//          if(nums[i] > minHeap.peek()){
//              minHeap.poll();
//              minHeap.add(nums[i]);
//          }
//      }
     
//      return minHeap.peek();
//     }
}