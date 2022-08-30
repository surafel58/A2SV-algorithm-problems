class Solution {
    public long countVowels(String word) {
        
        //counter for storing the result of the number of substring that conatins vowels
        long result=0;
        
        //total substring 
        long total_substring = (long)word.length() * ((long)word.length() + (long)1)/ (long)2;
        
        //stores the vowels 
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        
        //iterate through the string and calculate the amount of substrings that contains vowels
        for(int i=0; i<word.length(); i++)
        {
            if(vowels.contains(word.charAt(i)))
                //calculate the number of substrings that contain the current vowel character at each iteration
                result += (total_substring - (substrWithoutChar(i - 0) + substrWithoutChar((word.length() - 1) - i)));
        }   
        
        //return the result
        return result;
    }
    
    //calculate the total amount of substrings with out containing the given vowel character
    public long substrWithoutChar(int n)
    {
        return ((long)n*((long)n + (long)1) / (long)2);
    }
}
