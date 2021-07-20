/*
to solve this qxn to reach a dest from src 
first we add adges to the graph 
then connect the edges since its a dirsted graph
now we check for a cycle 
then we check if there is no outgoing edge but current node is equal to dest
then if any edge return false in the sense of no outgoing edge but we hve already seen we return false
then we mark it as seen
then return false
time com = O(V + E) | Space = O(V + E)
*/
class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int[] edge : edges){
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
        }
        
        return dfs(source, destination, graph, new HashSet<>());
        
    }
    
    public boolean dfs(int nodes, int destination,  Map<Integer, List<Integer>> graph,  Set<Integer> seen){
        
        if(!graph.containsKey(nodes) && nodes == destination) return true;
        if(!graph.containsKey(nodes) || seen.contains(nodes)) return false;
        
        
        for(int child : graph.get(nodes)){
            
            seen.add(nodes);
            if(!dfs(child, destination, graph, seen)){
                return false;
            }
            
            seen.remove(nodes);
        }
        return true;
    }
}