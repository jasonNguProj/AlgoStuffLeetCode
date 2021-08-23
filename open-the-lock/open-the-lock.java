
/*
to solve this problem we have to understand 2 things 
which are return min num turns which is min distance 
and also we are given states , and a target this are key 
things to understand that this is a graph problem
and since its asking for min distance we'll use bfs which 
is best suited for finding min distance, and given a start
pos we are changing states 
so you can view this question like 
give 01 we are changing it 4 times like add upp by 1 for 4 vals
add down 1 time for 4 vals
so we will solve this via bfs statndard procedue


*/

class Solution {
    public int openLock(String[] deadends, String target) {
        
        Set<String> deadEnds = new HashSet<>(Arrays.asList(deadends));
        if(deadEnds.contains("0000")) return -1;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        queue.offer("0000");
        visited.add("0000");
        
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                String lockpos = queue.poll();
                
                if(lockpos.equals(target)){
                    return level;
                }
                StringBuilder sb = new StringBuilder(lockpos);
                for(int c = 0; c < 4 ; c++){
                    char current = sb.charAt(c);
                    
                    String s1 = sb.substring(0, c) + ( current == '9' ? 0 : current - '0' + 1) + sb.substring(c + 1);
                    String s2 =sb.substring(0, c) + ( current == '0' ? 9 : current - '0' - 1) + sb.substring(c + 1);
                        
                        if(!visited.contains(s1) && !deadEnds.contains(s1)){
                            visited.add(s1);
                            queue.offer(s1);
                        }
                    
                     if(!visited.contains(s2) && !deadEnds.contains(s2)){
                            visited.add(s2);
                            queue.offer(s2);
                        }
                }
            }
            level++;
        }
        return -1;
    }
}