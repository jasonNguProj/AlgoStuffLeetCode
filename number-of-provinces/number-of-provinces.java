
// create a visited array , with initialy zeros
// visited is equal to 1, if its not visted
// then we check each prov neighbors and set visted to 1
// class Solution {
//     public int findCircleNum(int[][] isConnected) {
//         int[] visited = new int[isConnected.length];
//         int province = 0;
//         for(int i = 0; i < isConnected.length; i++){
//             if(visited[i] == 0){
//             dfs(isConnected, visited, i);
//             province++;
//             }
            
//         }
//         return province;
        
//     }
    
//     public void dfs(int[][] isConnected, int[] visited, int start){
        
//         for(int j =0; j < isConnected.length; j++){
//             if(isConnected[start][j] == 1 && visited[j] == 0){
//                 visited[j] = 1;
//                 dfs(isConnected, visited, start);
//             }
//         }
//     }
// }


class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count  = 0;
        Set<Integer> set = new HashSet();
        
        for(int i = 0 ;i< isConnected.length; i++ ){
            if(!set.contains(i)){
                dfs(isConnected,set, i);
                count +=1;
            }
        }
        return count;
    }
    public void dfs(int[][] isConnected, Set<Integer> set,int i){
        for(int j = 0;j<isConnected.length;j++ ){
            if(isConnected[i][j] == 1 && !set.contains(j)){
                set.add(j);
                dfs(isConnected,set,j);
            }
        }
    }
}