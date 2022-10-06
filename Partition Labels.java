class Solution {
    public List<Integer> partitionLabels(String s) {
        
        //store result
        ArrayList<Integer> result = new ArrayList<>();
        
        //store visited characters in hashmap with its index
        HashMap<Character, Integer> characters = new HashMap<>();
        
        //i,j - iterators max - store max index, temp - temp var
        int i = 0, j = s.length()-1, max = Integer.MIN_VALUE, temp = i;
        
        //to check if partition is already found 
        boolean isPartitionFound = false;
        
        //iterate through the array
        while(i < s.length())
        {
            //if i == max, which means 1 partition is found, where each visisted letter appears in at most this partition.
            if(i == max)
            {
                //add the partition size to list
                result.add(max - temp + 1);
                
                //make isPartitionFound true, to indicate that partition is found
                isPartitionFound = true;
            }
            
            //if the current char is already in hasmap, goto next element
            if(characters.containsKey(s.charAt(i)))
            {
                i++;
                
                //if partition is already found, update temp, to calculate the next partition size 
                if(isPartitionFound)
                    temp = i;
                
                //make it false
                isPartitionFound = false;
            }
                
            //otherwise, iterate from the back and find for the given element  
            else
            {
                j = s.length()-1;
                while(s.charAt(i) != s.charAt(j))
                    j--;
                
                //put the char in hashmap, with its index(j)
                characters.put(s.charAt(i), j);
                
                //udate max index, for the next partition to be found
                max = Math.max(max, j);
            }
        }
        
        //return the list
        return result;
    }
}
