class Solution {
    public int lengthOfLongestSubstring(String s) {
        //max_length - maximum length of substring, windowStart, windowEnd - two pointers 
        int max_length = 0, windowStart = 0, windowEnd = 0;
        
        //hashmap to store distinct characters
        HashMap<Character, Integer> distinct_chars = new HashMap<>();
        
        //iteratre through the string using sliding window technique
        while(windowEnd < s.length())
        {
            //if the char doesnt exist in the hashmap, add it to the hashmap with its frequency
            if(distinct_chars.get(s.charAt(windowEnd)) == null || distinct_chars.get(s.charAt(windowEnd)) == 0)
            {
                if(distinct_chars.get(s.charAt(windowEnd)) == null)
                    distinct_chars.put(s.charAt(windowEnd), 0);
                distinct_chars.put(s.charAt(windowEnd), distinct_chars.get(s.charAt(windowEnd)) + 1);
                windowEnd++;
            }
            //else, store the max Length of the given substrings so far and decrement the frequency of the corresponding char in the hasmap
            else
            {
                max_length = Math.max(max_length, windowEnd - windowStart);
                distinct_chars.put(s.charAt(windowStart), distinct_chars.get(s.charAt(windowStart)) - 1);
                windowStart++;
            }
        }
        
        //handle exceptional case
        max_length = Math.max(max_length, windowEnd - windowStart);
        
        //return the length of the longest substring
        return max_length;
    }
}