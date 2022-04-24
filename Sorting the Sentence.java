class Solution {
    public String sortSentence(String s) {
        //splitted the sentence word by word
        String[] words = s.split(" ");
        //a hasmap for storing the words in order
        HashMap<Integer, String> mapWords = new HashMap<>();
        //creating a stringbuilder to manuplate the string 
        StringBuilder sMutable = new StringBuilder();
        //a for loop for putting each words mapped with their corresponding order numbers in the hashmap 
        for(int i=0; i<words.length; i++)
            mapWords.put(Integer.parseInt(words[i].substring(words[i].length()-1)), words[i].substring(0, words[i].length()-1));
        //concatinating the words in their proper order to the mutable string   
        for(Integer i=0; i<words.length; i++)
            sMutable.append(mapWords.get(i+1) + " ");
        //storing the result with trimming the leading and trailing spaces if any 
        String result = sMutable.toString().trim();
        //return the final result 
        return result;
    }
}