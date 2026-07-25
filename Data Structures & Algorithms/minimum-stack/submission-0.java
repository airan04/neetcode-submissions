class MinStack {
    Stack<Integer> st;
    Stack<Integer> minStack;

    public MinStack() {
        this.st=new Stack<>();
        this.minStack=new Stack<>();
    }
    
    public void push(int value) {
        st.push(value);
        if(minStack.isEmpty() || value<=minStack.peek()){
            minStack.add(value);
        }
    }
    
    public void pop() {
        if (st.isEmpty()) return;
        int top=st.pop();
        if(top == minStack.peek()){
            minStack.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        if(minStack.isEmpty()){
            return 0;
        }
        return minStack.peek();
    }
}