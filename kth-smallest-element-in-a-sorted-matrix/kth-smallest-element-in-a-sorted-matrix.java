// so basily it will be 8, 7, 6, 5, 4, 3, 2, 1 ... 15 , we will keep polling untill the heap size is same 
// k , when the heap size is same as k we return the 8th smallest which will be at the peek when k = minheap.size
//O(n log n + o (m * n))

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((e1,e2) -> e2 - e1);
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                maxHeap.offer(matrix[i][j]);
                if(maxHeap.size() > k){
                    maxHeap.poll();
                }
            }
        }
        return maxHeap.peek();
        
    }
}