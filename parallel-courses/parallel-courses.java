/*
so for this question we will use topo sort to solve problem
so we only add to queue when the value is 0;
so for to sort,  we'll need a hmap indegree, map too for graph, 
alse when ever we are adding an edge we want to increase the value 
and then while q is not empty we increment our courses ,
when ever our result size is equal to given nodes we return min courses else -1
*/

class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> courses = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        int minSemester = 0;
        
        for(int i = 1; i <= n ; i++){
            graph.put(i, new ArrayList<>());
            indegree.put(i, 0);
        }
        
        for(int[] rel : relations){
            graph.get(rel[0]).add(rel[1]);
            indegree.put(rel[1], indegree.get(rel[1]) + 1);
        }
        
        indegree.entrySet().stream().forEach(entry ->{
            if(entry.getValue() == 0){
                queue.offer(entry.getKey());
            }
        });
        
        while(!queue.isEmpty()){
            minSemester++;
            for(int i = queue.size() - 1; i >=0; i--){
                int node = queue.poll();
                courses.add(node);
                
                
                for(int neighbor : graph.get(node)){
                    indegree.put(neighbor, indegree.get(neighbor) - 1);
                    
                    if(indegree.get(neighbor) == 0){
                        queue.offer(neighbor);
                    }
                }
            }
        }
        
        return courses.size() == n ? minSemester : -1;
    }
}