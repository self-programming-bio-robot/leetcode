class MyQueue {
    
    private Deque<Integer> a = new LinkedList();
    private Deque<Integer> b = new LinkedList();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        while(!a.isEmpty()) {
            b.push(a.pop());
        }
        a.push(x);
        while(!b.isEmpty()) {
            a.push(b.pop());
        }
    }
    
    public int pop() {
        return a.pop();
    }
    
    public int peek() {
        return a.peek();
    }
    
    public boolean empty() {
        return a.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
