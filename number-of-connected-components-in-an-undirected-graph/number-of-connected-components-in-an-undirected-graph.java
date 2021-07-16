class Solution {
    // first let me build the graph
    // add thedge and vertices to the graph using an adjacencyList
    // and traverse BFS manner to store the nodes in queue
    public int countComponents(int n, int[][] edges) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(i, new ArrayList<>());
        }
        
        
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
             graph.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        
        for(int i = 0; i < n ; i++){
            if (!visited.contains(i)){
                bfs(graph, i, visited);
                count++;
            }
        }
        
        return count;
    }
    
    public void bfs(List<List<Integer>> graph, int i,  Set<Integer> visited){
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited.add(i);
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            
            for(int neighbors : graph.get(node)){
                if(!visited.contains(neighbors)){
                    visited.add(neighbors);
                    queue.offer(neighbors);
                }
            }
        }
    }
}