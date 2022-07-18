class Solution {
    public int compress(char[] chars) {
        //variable to store the compressed string 
        String s = "";
        //two pointers and a counter for duplicated items 
        int n=0, index1=0, index2=0;
        //iterate thorugh the array until index2 is out of bound, and move the two pointers consecuitively to build compressed string  
        while(index2!=chars.length)
        {
            //if the charachters pointed by the index1 and index2 are the same increment the counter and move the second pointer 
            if(chars[index1] == chars[index2])
            {
                n++;
                index2++;
            }
            //else append the char to s and also append its frequency if it has duplicates - compress the strings  
            else
            {
                if(n==1)
                    s += String.valueOf(chars[index1]);
                else
                    s += String.valueOf(chars[index1]) + n;
                //reinitialzie counter for the next char
                n = 0;
                //move the first pointer to the same place the second pointer is pointing too
                index1 = index2;
            }
        }
        
        //append the remaining char 
        if(n==1)
            s += String.valueOf(chars[index1]);
        else
            s += String.valueOf(chars[index1]) + n;
        
        //copy the compressed string to the char array 
        for(int i=0; i < s.length(); i++)
            chars[i] = s.charAt(i);
        
        //return the length of the compressed string
        return s.length();
    }
}