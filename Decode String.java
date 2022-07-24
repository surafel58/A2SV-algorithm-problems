class Solution {
    public String decodeString(String s) {
        if(s.length() == 1)
            return s;
        
        Stack<String> result = new Stack<>();
        int index=0;
        while(index != s.length())
        {
            if(s.charAt(index) != ']')
                result.push(String.valueOf(s.charAt(index)));
            
            else
            {
                String num = "";
                String str = "";
                while(!result.peek().equals("["))
                    str = result.pop() + str;
                
                result.pop();
                
                while(!result.empty() && result.peek().chars().allMatch(Character::isDigit))
                    num = result.pop() + num;
                
                String decode = repeatString(Integer.parseInt(num), str);
                result.push(decode);
            }
            
            index++;
        }
        
        String decoded_string = "";
        Iterator<String> itr = result.iterator();
        
        while(itr.hasNext())
            decoded_string+=itr.next();
        return decoded_string;
    }
    
    public String repeatString(int rep, String val)
    {
        if(rep == 1)
            return val;
        String decode = val + repeatString(rep-1, val);
        return decode;
    }
}