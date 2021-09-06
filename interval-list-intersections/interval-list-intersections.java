/*
to solve this problem we need a start pointer and an end pointer
we need to traverse via the first and send list and compute the 
start and the end value

so we need to understand that to get our start interveral
is the max of a start and b start and the end 
is min a end and eb end
and to be able to have an intersection 
end >= start, then we add our start and end inot our result
then when bend >  aend we incree a ii



*/


class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        
        int i = 0, j =0;
        
        List<int[]> result = new ArrayList<>();
        while(i < firstList.length && j < secondList.length){
            
            int start = Math.max(firstList[i][0], secondList[j][0]);
             int end = Math.min(firstList[i][1], secondList[j][1]);
            
            if(end >= start){
                result.add(new int[]{start, end});
            }
            
            if(firstList[i][1] < secondList[j][1]){
                i++;
            } else{
                j++;
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}