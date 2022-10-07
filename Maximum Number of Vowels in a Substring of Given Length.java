class Solution {
    public int maxVowels(String s, int k) {
        
        //sliding window technique
        int windowStart = 0, windowEnd = 0, maxVowel = Integer.MIN_VALUE, currentVowels = 0;
        
        //iterate through the string and slide a window of size k, and count the vowels and store max vowels of a substring
        while(windowEnd < s.length())
        {
            if(s.charAt(windowEnd) == 'a' || s.charAt(windowEnd) == 'e' || s.charAt(windowEnd) == 'i' || s.charAt(windowEnd) == 'o' || s.charAt(windowEnd) == 'u')
                currentVowels++;
            
            if(windowEnd - windowStart + 1 == k)
            {
                maxVowel = Math.max(maxVowel, currentVowels);
                if(s.charAt(windowStart) == 'a' || s.charAt(windowStart) == 'e' || s.charAt(windowStart) == 'i' || s.charAt(windowStart) == 'o' || s.charAt(windowStart) == 'u' )
                    currentVowels--;
                
                windowStart++;
            }
            
            windowEnd++;
        }
        
        //return the max vowel
        return maxVowel;
    }
}
