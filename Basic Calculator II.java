class Solution {
    
    public int calculate(String s) {
        //remove unneeded spaces
        s = s.replaceAll("\\s+","");

        //convert to postfix notation
        String[] postfixS = infixToPostfix(s).split(" ");
        
        //evaluate Reverse polish notation
        int result = evalRPN(postfixS);
        
        //return result
        return result;
     }
    
    //operator precedence
    public int Prec(char ch)
    {
        switch (ch)
        {
        case '+':
        case '-':
            return 1;

        case '*':
        case '/':
            return 2;
        }
        return -1;
    }
    
    public String infixToPostfix(String exp)
    {
        
        // initializing empty String for result
        StringBuffer result = new StringBuffer();
        
         
        // initializing empty stack
        Stack<Character> stack = new Stack<>();
        
        //problem here
        for (int i = 0, length = exp.length(); i<length; i++)
        {
            char c = exp.charAt(i);
                
            
            // If the scanned character is an
            // operand, add it to output.
            if (Character.isDigit(c))
            {
                //append " " inorder to split the reverse polish notation string and store it in charArray later
                if(!stack.isEmpty() && !Character.isDigit(exp.charAt(i-1))){
                    // result+=" ";
                    result.append(" ");
                } 
                // result += c;
                result.append(c);
            }

            else // an operator is encountered
            {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())){
                    result.append(" ");
                    result.append(stack.pop());
                }
                    // result = result + " " + stack.pop();
                stack.push(c);
            }
        }
      
        // pop all the operators from the stack
        while (!stack.isEmpty()){
            result.append(" ");
            result.append(stack.pop());
        }
            
            // result = result + " " + stack.pop();
        
        return result.toString();
    }
    
    public int evalRPN(String[] tokens)
    {
        //stack to store the operands
        Stack<Integer>operands = new Stack<>();
        boolean isOperatorFound = false;
        
        //iterate through the string array and push numbers on the stack, if the given string is an operator then pop two numbers from          the stack and calculate the result then push it back on the stack, iterate until we get to end of the string array 
        for(int i=0; i<tokens.length; i++)
        {
            if(tokens[i].equals("+") || tokens[i].equals("-")  || tokens[i].equals("*") || tokens[i].equals("/") )
            {
                isOperatorFound = true;
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