class MyCircularDeque {
    //circular deque (array)
    int[] c_deque;
    //queue size -current deque size, 
    //rear - point to the last element in the circular deque,
    //front - point to the first element in the circular deque
    //maxsize - maximum size of the circular deque
    int queuesize = 0, rear=-1, front=-1;
    int maxsize = 0;
    public MyCircularDeque(int k) {
        //initialize
        c_deque = new int[k];
        maxsize = k;
    }
    
    public boolean insertFront(int value) {
        if(queuesize < maxsize)
        {
            front--;
            if(front == -2)
            {
                if(isEmpty())
                    front=0;
            }
            if(front==-1)
                front=maxsize-1;
            
            if(rear==-1)
                rear++;
            
            queuesize++;
            c_deque[front] = value;
            return true;
        }
        return false;
    }
    
    public boolean insertLast(int value) {
        if(queuesize < maxsize)
        {
            rear++;
            if(rear==maxsize)
                rear=0;
            if(front==-1)
                front++;
            queuesize++;
            c_deque[rear] = value;
            return true;
        }
        return false;
    }
    
    public boolean deleteFront() {
        if(queuesize != 0)
        {
            front++;
            if(front == maxsize)
                front=0;
            queuesize--;
            return true;
        }
        return false;
    }
    
    public boolean deleteLast() {
        if(queuesize != 0)
        {
            rear--;
            if(rear == -1)
                rear=maxsize-1;
            queuesize--;
            return true;
        }
        return false;
    }
    
    public int getFront() {
        if(!isEmpty())
            return c_deque[front];
        return -1;
    }
    
    public int getRear() {
        if(!isEmpty())
            return c_deque[rear];
        return -1;
    }
    
    public boolean isEmpty() {
        if(queuesize <= 0)
            return true;
        return false;
    }
    
    public boolean isFull() {
        if(queuesize == maxsize)
            return true;
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */