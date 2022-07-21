class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        //result array
        int[] result = new int[temperatures.length];
        
        //if length == 0, return the result 
        if(temperatures.length == 0)
            return result;
        
        //monotonic stack(decreasing)
        Stack<Integer> mono_stack = new Stack<>();
        
        //iterate throguh the array and build a decreasing monotonic stack, but if greater element is found compared to the top of  the stack, calculate its distance from the larger number and store the distance in the result array, and pop the number from stack, do this until stack is empty or lesser element is encountered, and just keep pushing the number on the stack if its lesser(decreasing stack)
        for(int i=0; i < temperatures.length; i++)
        {
            while(!mono_stack.empty() && temperatures[mono_stack.peek()] < temperatures[i])
            {
                result[mono_stack.peek()] = i - mono_stack.peek();
                mono_stack.pop();
            }
            mono_stack.push(i);
        }
        
        //return the result
        return result;
    }
}