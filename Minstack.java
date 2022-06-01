class MinStack {
    Stack<Integer> stack;
    public MinStack() {
        //initialize stack
        stack = new Stack<>();
    }
    
    public void push(int val) {
        //push the value to the list
        stack.push(val);
    }
    
    public void pop() {
        //remove the last element and return it
        int value = stack.pop();
    }
    
    public int top() {
        //return the last element 
        int value = stack.peek();
        return value;
    }
    
    public int getMin() {
        //copy the stack and sort in reverse order the copied stack inorder not to change the original stack 
        Stack<Integer> stackcopy = (Stack)stack.clone();
        Collections.sort(stackcopy, Collections.reverseOrder());
        //return the first element(already reverse sorted, minimum is the last element)
        int min = stackcopy.peek();
        return min;
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