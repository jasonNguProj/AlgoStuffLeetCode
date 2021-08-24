/*
to solve this problem we need to understand some key info 
firstly asking us the min to reach end from start at this point
when u here min dist u think bfs .
so for this question we are going to solve via bfs and changing every xter
between a to z and not we start our level at 1 because at min we'll always hve
our start work in our graph sequence 

*/


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> set = new HashSet<>(wordList);  
        if(!set.contains(endWord)) return 0;  
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        
        int changes  = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                String curr = queue.poll();  
                if(curr.equals(endWord)) return changes;
                
                for(int j = 0; j < curr.length(); j++){
                    for(int k = 'a'; k <= 'z'; k++){
                         char[] currentPos = curr.toCharArray();
                        currentPos[j] = (char) k; 
                        String currWord = new String(currentPos);
                        
                        if(set.contains(currWord) && !visited.contains(currWord)){
                            queue.offer(currWord);
                            visited.add(currWord);
                        }
                    }
                }
            }
            changes++;
        }
        return 0;
        
    }
}