class Solution {
    public long getDescentPeriods(int[] prices) {
        
        //store the number of smooth descent periods
        long result = 0;
        
        //stack to store descent periods
        Stack<Integer> descent_periods = new Stack<>();
        
        
        //iterate through the array to calculate the number of smooth descent periods
        for(int i=0; i<prices.length; i++)
        {
            
            //if its not empty and the price difference(stack top and current day price) is different from 1, add the number of smooth descent periods so far(from the stack) and clear the stack
            if(!descent_periods.empty() && (descent_periods.peek() - prices[i] != 1))
            {
                result += ((long)descent_periods.size() * ((long)descent_periods.size() + (long)1) / (long)2);
                descent_periods.clear();
            }
            
            //push prices into the stack
            descent_periods.push(prices[i]);
        }
        
        //add the remaining smooth descent periods  
        result += ((long)descent_periods.size() * ((long)descent_periods.size() + (long)1) / (long)2);
        
        //return the result
        return result; 
    }
}