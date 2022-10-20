class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        //result list
        ArrayList<Integer> result = new ArrayList<>();
        
        int windowStart = 0, windowEnd = 0;
        
        //store letters of string p with their frequency
        HashMap<Character, Integer> p_freq = new HashMap<>();
        
        //store if there are characters outside the string p in my window
        HashMap<Character, Integer> invalidChars = new HashMap<>();
        
        //store if there are extra characters that are found in string p in my window
        HashSet<Character> extraChars = new HashSet<>();
        
        //copy the values into hashmap with it freq
        for(int i=0; i<p.length(); i++)
        {
            if(p_freq.get(p.charAt(i)) == null)
                p_freq.put(p.charAt(i), 0);
            p_freq.put(p.charAt(i), p_freq.get(p.charAt(i)) + 1);
        }
        
        //tell if extra char is used from string p
        boolean invalid = false;
        
        
        while(windowEnd < s.length())
        {
            //if current char doesnt exist in p, then add this char to invalidChars
            if(!p_freq.containsKey(s.charAt(windowEnd)))
            {
                if(invalidChars.get(s.charAt(windowEnd)) == null)
                    invalidChars.put(s.charAt(windowEnd), 0);
                invalidChars.put(s.charAt(windowEnd), invalidChars.get(s.charAt(windowEnd)) + 1);
            }
            
            //else if it exists , then check if we used extra char from p, if thats the case make invalid true 
            else if(p_freq.containsKey(s.charAt(windowEnd)))
            {
                if(p_freq.get(s.charAt(windowEnd)) <= 0)
                {
                    extraChars.add(s.charAt(windowEnd));
                    invalid = true;
                }
                
                //decrease freq of the used char found in p
                p_freq.put(s.charAt(windowEnd), p_freq.get(s.charAt(windowEnd)) - 1);
            }
            
            //if desired length is reached
            if(windowEnd - windowStart + 1 == p.length())
            {
                //cehck if we didnt use extra char from p and no invalid char is found
                if(!invalid && invalidChars.size() == 0)
                    result.add(windowStart);
                
                //if the char we are about to eliminate from our window is an invalid char decrease its freq in invalidChar 
                if(invalidChars.containsKey(s.charAt(windowStart)))
                {
                    invalidChars.put(s.charAt(windowStart), invalidChars.get(s.charAt(windowStart)) - 1); 
                    if(invalidChars.get(s.charAt(windowStart)) == 0)
                        invalidChars.remove(s.charAt(windowStart));
                }
                //otherwise, the char is found in the string p,
                else
                {
                    //increment its freq, since we are not using this char anymore
                    p_freq.put(s.charAt(windowStart), p_freq.get(s.charAt(windowStart)) + 1);
                    
                    //if it is an extra char
                    if(extraChars.contains(s.charAt(windowStart)))
                    {
                        //check if we are not using this char anymore 
                        if(p_freq.get(s.charAt(windowStart)) >= 0)
                            extraChars.remove(s.charAt(windowStart));
                    }
                    
                    //if there are no extra char then make invalid false again
                    if(extraChars.size() == 0)
                        invalid = false;
                }
                
                //decrease window size
                windowStart++;
            }
            
            //increase window size
            windowEnd++;
        }
        
        //return list
        return result;
    }
}
