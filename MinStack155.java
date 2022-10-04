class MinStack {
    
    private Node top;
    private int min;

    public MinStack() {
    }
    
    public void push(int val) {
        int min = top == null ? val : Math.min(top.min, val);
        top = new Node(val, top, min);
    }
    
    public void pop() {
        top = top.next;
    }
    
    public int top() {
        return top.val;
    }
    
    public int getMin() {
        return top.min;    
    }
}

class Node {
    public int val;
    public Node next;
    public int min;
    
    public Node(int val, Node next, int min) {
        this.val = val;
        this.next = next;
        this.min = min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
