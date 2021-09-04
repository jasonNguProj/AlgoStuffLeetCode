/*
to solve this problem we need to understand that there is direction from parent 
to child, and child to parent, so we treat the problem as an undirected graph
and count the edges, if edge is from parent to child its positive we add 1, else from 
child to parent is negative we add 0, the positive connections will essentially be the 
number of edges changed , so given the input we build the graph and traverse
in a preorder dfs manner;
to build graph we need to first rep graph we need to trav the list and add 
the list into our graph list , connect the edges 
*/

class Solution {
    public int minReorder(int n, int[][] connections) {
        
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] con : connections){
            graph.get(con[0]).add(con[1]);
            graph.get(con[1]).add(- con[0]);
        }
        
        return dfs(0, graph, visited);
    }
    
    
    public int dfs(int start, List<List<Integer>> graph, boolean[] visited){
        
        int count = 0;
        visited[start] = true;
        
        List<Integer> children = graph.get(start);
        
        for(Integer child : children){
            
            if(!visited[Math.abs(child)])
            count += dfs(Math.abs(child), graph, visited) + (child > 0 ? 1 : 0);
        }
        
        return count;
    }
}