class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
         List<int[]> temp = new ArrayList<>();
    
    int[] segment = newInterval;
    
    for(int[] current:intervals){
        if(segment[1] < current[0]){
            temp.add(segment);
            segment = current;
        }else if(current[1] < segment[0]){
            temp.add(current);
        }else{
            segment[0] = Math.min(segment[0], current[0]);
            segment[1] = Math.max(segment[1], current[1]);
        }
    }
    
    temp.add(segment);
    
    int[][] result = new int[temp.size()][2];
   
    return  temp.toArray(result);
    }
}