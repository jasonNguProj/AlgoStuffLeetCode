
/*
to solve this problem we need to understand that we're trying to 
match brakets , and a perfect data structure for this 
will be the stack where we match our present elemnt with the element at the peek 
then we return true if at the end our stack is empty because
in essense our stack needs to be empty inorder for the input to be valid 
we use deque over stack because deque is an interface, acts like a stack, 
stack is also inconsistent as you can acces an element by index which is inconsistent



*/

class Solution {
    public boolean isValid(String s) {
        
        Deque<Character> queue = new ArrayDeque<>();
        
        for(char c : s.toCharArray()){
            if(queue.isEmpty()) queue.offer(c);
            else if(c == ')'  && queue.peek() == '(') queue.poll();
             else if(c == '}'  && queue.peek() == '{') queue.poll();
             else if(c == ']'  && queue.peek() == '[') queue.poll();
             else queue.push(c);
        }
          return queue.isEmpty() ? true : false;
        } 
    }
