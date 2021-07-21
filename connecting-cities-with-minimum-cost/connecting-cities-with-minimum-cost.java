/*
first we build the graph
then create a visisted hashset to hold our seen
create a minheap to hold min prices 
then use queue and traverse bfs way
if cities = num of nodes meaning we can find cost else return --
so connecting (node 1 - > node 2 && n1 -> 3) > (n2 -> 5 && n2 -> 3)
                        5 + 6 = 11          >    5 + 1 = 6
*/

class Solution {
    public int minimumCost(int n, int[][] connections) {
        
        if(n == 1) return 0;
        List<List<int[]>> graph = gr(n, connections);
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        HashSet<Integer> visited = new HashSet<>();
        minHeap.offer(new int[] { 1, 0});
        int cost =0, city =0;
        
        while(!minHeap.isEmpty()){
            int[] node = minHeap.poll();
            
            if(visited.contains(node[0])) continue;
            
            visited.add(node[0]);
            cost += node[1];
            city++;
            
            for(int[] neighbor : graph.get(node[0])){
                if(!visited.contains(neighbor[0])){
                    minHeap.offer(new int[] {neighbor[0], neighbor[1]});
                }
            }
        }
        return city == n ? cost : -1;
        
    }
    
    
    public List<List<int[]>> gr(int n, int[][] connections){
        
        List<List<int[]>> graph = new ArrayList<>();
        
        for(int i = 0; i <= n ; i++){
            graph.add(i, new ArrayList<>());
        }
        
        
        for(int[] con  : connections){
            int u = con[0] , v = con[1], price = con[2];
            graph.get(u).add(new int[] {v, price});
             graph.get(v).add(new int[] {u, price});
        }
        return graph;
    }
}