/*
to solve this qxn we'll use a maxHeap and dequeue
maxHeap to get max of elements and deque as it can be used as queue fifo
or stack lifo

*/


class MaxStack {

    PriorityQueue<Integer> maxHeap  = new PriorityQueue<Integer>((e1, e2) -> e2 - e1);
    Deque<Integer> deque = new LinkedList<>();
    /** initialize your data structure here. */
    public MaxStack() {
      
    }
    
    public void push(int x) {
        maxHeap.offer(x);
        deque.push(x);
    }
    
    public int pop() {
        int node = deque.pop();
        maxHeap.remove(node);
        return node;
    }
    
    public int top() {
        return deque.peek();
    }
    
    public int peekMax() {
        return maxHeap.peek();
    }
    
    public int popMax() {
        int node = maxHeap.poll();
        deque.remove(node);
        return node;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */