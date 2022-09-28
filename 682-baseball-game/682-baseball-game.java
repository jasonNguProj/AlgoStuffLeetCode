
/*
to solve this question we'll use a stack
and follow operations being given to us 

we'll use a stack to support because its best suited for our purpose
*/

class Solution {
    public int calPoints(String[] operations) {
        
        Deque<Integer> dequeue = new LinkedList<>();
        
        for(int i = 0; i < operations.length; i++){
            
            if(operations[i].equals("+")){
                int first = dequeue.pop();
                int sec = first + dequeue.peek();
                dequeue.push(first);
                dequeue.push(sec);
            } else if(operations[i].equals("C")){
                dequeue.pop();
            } else if(operations[i].equals("D")){
                dequeue.push(2 * dequeue.peek());
            } else {
                dequeue.push(Integer.parseInt(operations[i]));
            }
        }
        
        int res = 0;
        
        while(!dequeue.isEmpty()){
            res+= dequeue.poll();
        }
        
        return res;
        
    }
}