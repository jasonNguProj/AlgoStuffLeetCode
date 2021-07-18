/*
for this question what we need to do is first sort the start times
then sort the end time and put in a min heap in acsending order
so when heap is not empty and start time is greater than ending time 
we remove the top element since the start time is greater than it 
then we add the element to pq 
and at the end the heap size will be the min num of rooms required

*/


class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        
        for(int[] interval : intervals){
            if(!minHeap.isEmpty() && interval[0] >= minHeap.peek()[1]){
                minHeap.poll();
            }
            minHeap.offer(interval);
        }
        return minHeap.size();
    }
}