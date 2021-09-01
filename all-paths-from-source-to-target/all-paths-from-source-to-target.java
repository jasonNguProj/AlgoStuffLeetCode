/*
firstly when u hear of a qxn asking for possible paths
that should be a hint that you should use backtracking 
as u have to explore a node and its node as 1 solution
and then bactrack from that neighbor inorder to explore 
the other neighbor, 
so in this question we will have a path var that will keep track of paths
to mimic a visited flag of nodes visited then call our fxn recursively to visit the neighbors 
deep then inorder to visit other neighbors we backtrack from that 
and remember that u need to assume 0 as start node

then in the end when we reach the end we just add our visited nodes to our result



*/

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        
        List<List<Integer>> result = new ArrayList<>();
        if(graph.length == 0) return result;
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, path, result);    
        return result;
    }
    
    private void dfs(int[][] graph, int start,  List<Integer> path, List<List<Integer>> result){
        
        if(start == graph.length - 1){
            result.add(new ArrayList<>(path));
            return;
        }
        
        for(int n : graph[start]){
            path.add(n);
            dfs(graph, n, path, result);
            path.remove(path.size() - 1);
        }
    }
}