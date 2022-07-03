class MyQueue {
    //a list to store the elements
    List<Integer> s1;

    public MyQueue() {
        //initialize the list
        s1 = new ArrayList<>();
    }
    
    public void push(int x) {
        //append the given element
         s1.add(x);
    }
    
    public int pop() {
        //return the first element and remove it
        int x = s1.get(0);
        s1.remove(0);
        return x;
    }
    
    public int peek() {
        //return the first element
        return s1.get(0);
    }
    
    public boolean empty() {
        //check if it is empty and return the result 
        return s1.isEmpty();
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