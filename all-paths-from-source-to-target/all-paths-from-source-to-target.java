/*
to solve this question i will use dfs recursive 
via backtracking



*/



class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(graph.length == 0 || graph == null) return res;
            List<Integer> path = new ArrayList<>();
                path.add(0);
        dfs(res, path, 0, graph);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> path, int start, int[][] graph){
        
        
        if(start == graph.length - 1){
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int n : graph[start]){
            path.add(n);
            dfs(res, path, n, graph);
            path.remove(path.size() - 1);
            
        }
        
        
    }
}