class Solution {
    public boolean isValid(String s) {
        //string length
        int length = s.length();
        //stack to store open brackets
        Stack<String> open_brackets = new Stack<>();
        //check if any closed bracket appears at the first position 
        if(s.charAt(0)==')'||s.charAt(0)==']'||s.charAt(0)=='}')
            return false;
        //check if any open bracket appears at the last position
        if(s.charAt(length-1)=='('||s.charAt(length-1)=='['||s.charAt(length-1)=='{')
            return false;
        
        //iterate through the string to check its validity 
        int i=0;
        for( ;i<length; i++)
        {
            //if the given char is open bracket then push it on the stack
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{')
                open_brackets.push(String.valueOf(s.charAt(i)));
            //else pop from the stack and check if the current char is not a corresponding closed bracket for the popped open bracket
            else
            {
                //if the stack is empty break out of the loop
                if(open_brackets.empty())
                    break;                
                //store the popped open bracket
                String x = open_brackets.pop();
                //if the current char is not a corresponding closed bracket for the popped open bracket, return false 
                if(x.equals("(") && s.charAt(i) != ')')
                    return false;
                
                if(x.equals("[") && s.charAt(i) != ']')
                    return false;
                
                if(x.equals("{") && s.charAt(i) != '}')
                    return false;
            }
        }
        
        
        //if the stack is not still empty or i is not equal to the lenght(if the loop isnt finished iterating through the string), return false
        if(!open_brackets.empty() || i!=length)
            return false;
        
        //return true if all the above conditions are false
        return true;
    }
}