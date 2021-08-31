/*
to solve this problem we'll use a bfs where we'll store the rooms in a hmap for 
quick lookup and set a counter in the end if the counter is equal to the size
of our input matrix then we return true


*/

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> deque = new ArrayDeque<>();
            deque.offer(0);
        visited.add(0);
        
        while(!deque.isEmpty()){
                int i = deque.pop();
            for(int room : rooms.get(i)){
                if(!visited.contains(room)){
                    deque.offer(room);
                    visited.add(room);
                }
                if(visited.size() == rooms.size()) return true;
       }
           
        }
        return visited.size() == rooms.size();
    }
}