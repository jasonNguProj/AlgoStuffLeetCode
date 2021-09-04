/*
to solve this question i will build the graph and traverse the graph in a dfs 
manner and keep a count variable and then return the count
*/

class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int count = 0;
        
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
             graph.get(e[1]).add(e[0]);
        }
        
         for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(graph, visited, i);
                count++;
            }   
        }
        
        return count;
    }
    
    private void dfs(List<List<Integer>> graph, boolean[] visited , int start){
        
        
        visited[start] = true;
        
        for(Integer child : graph.get(start)){
            if(!visited[child]){
                dfs(graph, visited, child);
            }   
        }
        
    }
}