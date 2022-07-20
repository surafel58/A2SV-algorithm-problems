class Solution {
    public String reverseParentheses(String s) {
        
        //if only one character in the string, return s;
        if(s.length()==1)
            return s;
        
        //stacks to store open bracket and its corresponding index
        Stack<String>open_brackets = new Stack<>();
        Stack<Integer>index = new Stack<>();
        
        //iterates through the string s, and if it finds '(', push it on the stack and also its index, then if it gets ')', pop from the stack and reverse the string between those open and close brackets 
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i) == '(')
            {
                open_brackets.push(String.valueOf(s.charAt(i)));
                index.push(i);
            }
                
            else if(s.charAt(i) == ')')
            {
                open_brackets.pop();
                int ix = index.pop();
                s = reverseString(s, ix+1, i);
            }
            
            else
                continue;
        }
        
        //remove brackets frrom the string
        s = removebrackets(s);
        
        //return the result
        return s;
    }
    
    //reverse the given substring and return the updates String s 
    public String reverseString(String s, int i, int j)
    {
        String r_substring, reversed_string="";
        String input = s.substring(i, j);
        if(input =="")
            return s;
  
        // getBytes() method to convert string
        // into bytes[].
        byte[] strAsByteArray = input.getBytes();
  
        byte[] result = new byte[strAsByteArray.length];
  
        // Store result in reverse order into the
        // result byte[]
        for (int k = 0; k < strAsByteArray.length; k++)
            result[k] = strAsByteArray[strAsByteArray.length - k - 1];
  
        r_substring = new String(result);
        
        for(int k=0; k<s.length(); k++)
        {
            if(k==i)
            {
                reversed_string += r_substring;
                k=j-1;
            }
            else
                reversed_string += String.valueOf(s.charAt(k));
        }
        
        return reversed_string;
    }
    
    public String removebrackets(String s)
    {
        String result = "";
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i) == '(' || s.charAt(i) == ')')
                continue;
            result+=String.valueOf(s.charAt(i));
        }
        return result;
    }
}