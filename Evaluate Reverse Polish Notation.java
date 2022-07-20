class Solution {
    public int evalRPN(String[] tokens) {
        
        //if there is only one number return it
        if(tokens.length==1)
            return Integer.parseInt(tokens[0]);
        
        //staack to store the operands
        Stack<Integer>operands = new Stack<>();
        
        //iterate through the string array and push numbers on the stack, if the given string is an operator then pop two numbers from the stack and calculate the result then push it back on the stack, iterate until we get to end of the string array 
        for(int i=0; i<tokens.length; i++)
        {
            if(tokens[i].equals("+") || tokens[i].equals("-")  || tokens[i].equals("*")  || tokens[i].equals("/") )
            {
                int b = operands.pop();
                int a = operands.pop();
                char opr = tokens[i].charAt(0);
                switch(opr)
                {
                    case '+':
                        operands.push(a+b);
                        break;
                    case '-':
                        operands.push(a-b);
                        break;
                    case '*':
                        operands.push(a*b);
                        break;
                    case '/':
                        operands.push(a/b);
                        break;                        
                }
            }
               
            else
                operands.push(Integer.parseInt(tokens[i]));
        }
        
        //store the final result
        int result = operands.pop();
        
        //return the final result
        return result;
    }
}