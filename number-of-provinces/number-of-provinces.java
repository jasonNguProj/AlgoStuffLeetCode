
/*
we need to understand that we need to only traverse the graph 
when there is a connection and when not visited, and then 
increment a cont variable when every we start a new dfs
so note that we don't need to build a graph because the graph
is already built for us via TO Visualize
  A B C  so this is the representation of example1 to show how we got 1 so A con to A, B
A 1 1 0  SO A con A, A con B so B is the only neighbor of A
B 1 1 0  So B con A , B con B which is itself, so a is the only child of b
C 0 0 1  here c is con to itself and has no child,

and we want to traverse neigbor whre arr[i][j] = 1 (is a neighbor), and when its not visited
then we do a dfs on our start matrix
then traverse the array agn if not visited we do a dfs , and when ever we start a new dfs
we increment count, time is O(N)^2 | space is O(N) because of recursive stack

*/



class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int count = 0 ;
        boolean[] visited = new boolean[isConnected.length];
        
        for(int i = 0; i < isConnected.length; i++){
            if(!visited[i]){
                dfs(isConnected, visited, i);
                count++;
            }
        }
        
        return count;
    }
    
    public void dfs(int[][] isConnected, boolean[] visited, int i){
        
        for(int j = 0; j < isConnected[i].length; j++){
            if(!visited[j]  &&  isConnected[i][j] == 1){
                 visited[j]  = true;
            dfs(isConnected, visited, j);
            }
               
        }
    }
}