class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        //stack to store numbers from pushed array 
        Stack<Integer> items = new Stack<>();
        //pointer to keep track of pushed array 
        int k = 0;
        //iterate through the popped array and push the numbers found in pused array into the stack, while checking if a number is neeeded to be popped out of the stack, the result of the loop is either an empty stack or non empty stack. 
        for(int i=0; i<popped.length; i++)
        {
            //check first if the number on top of stack == the number to be popped, if true then pop the number out of the stack
            if(!items.empty() && items.peek() == popped[i])
            {
                items.pop();
                continue;
            }
            
            //otherwise check if the given number in the popped array is present in the pushed array 
            for(int j=k; j<pushed.length; j++)
            {
                //push the number in pushed array into the stack
                items.push(pushed[j]);
                
                //if found, then pop out the number and increment the pointer k from the current index, then break out of the loop
                if(pushed[j] == popped[i])
                {
                    k = j+1;
                    items.pop();
                    break;
                }
            }
        }
        
        //if stack is not empty, it means that the stack sequence is not correct
        if(!items.empty())
            return false;
        
        //otherwise if stack is empty the stack sequence is correct
        return true;
    }
}