// for a graph to be a valid tree first number of nodes suppose to be n- 1
// for a graph to be a tree it should not have a cycle
// we check for cycle edge.size = n(number of nodes)
// so we'll use BFS queue to traverse tree 
//use a hashet to keep track of seen nodes
//space is o(V + E) | Time is O(V + E)
class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        if (edges.length != n - 1) return false;
        
        List<List<Integer>> graph = new ArrayList<>();
        
        // traverse nodes and add to graph
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        
        // here we trav the 2d matrix to connect nodes to edges
        for(int[] vals : edges){
            graph.get(vals[0]).add(vals[1]);
        graph.get(vals[1]).add(vals[0]);
        }
        
        
        Queue<Integer> queue =  new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        
        queue.offer(0);
        seen.add(0);
        
        while(!queue.isEmpty()){
            int node = queue.poll(); 
            for(int neighbors : graph.get(node)){
                if(seen.contains(neighbors)) continue;
                seen.add(neighbors);
                queue.offer(neighbors);
            }
            
            //to check that theres no cycle all the nodes must be same as the elements in the set
        }
        return seen.size() == n;
    }
}