class Solution {
    public String removeKdigits(String num, int k) {
        int length = num.length();
        if(num.length() == k)
            return "0";
        
        Stack<Integer> mono_stack = new Stack<>();
        
        for(int i=0; i<num.length(); i++)
        {
            int number = Integer.parseInt(String.valueOf(num.charAt(i)));
            while(!mono_stack.empty() && mono_stack.peek() > number && k > 0)
            {
                mono_stack.pop();
                k--;
            }
            mono_stack.push(number);
        }
        
        while(k > 0)
        {
            mono_stack.pop();
            k--;
        }

        String result = "";
        Iterator<Integer> itr = mono_stack.iterator();
        boolean isFound = true;
        
        while(itr.hasNext())
        {
            int x = itr.next();
            if(x == 0 && isFound)
                continue;
            else
            {
                isFound = false;
                result+=x;
            }
        }
        
        if(result.equals(""))
            result = "0";
        
        return result;
    }
}