class Solution {
    public int[] findOriginalArray(int[] changed) {
        
        //changed array
        int[] result = new int[changed.length/2];
        
        //if array length is odd then its not doubled array
        if(changed.length % 2 != 0)
            return new int[]{};
        
        //hashmap to put numbers with their frequency
        HashMap<Integer, Integer> numbers = new LinkedHashMap<>();
        
        //index of result
        int i=0;
        
        //sort the changed array
        Arrays.sort(changed);
        
        //copy the values into hashmap with it freq
        for(int j: changed)
        {
            if(numbers.get(j) == null)
                numbers.put(j, 0);
            numbers.put(j, numbers.get(j)+1);
        }
        
        //iterate through the hash map
        for (Map.Entry<Integer, Integer> entry : numbers.entrySet()) {
            
            //get value and freq
            int value = entry.getKey();
            int freq = entry.getValue();
            
            //while the current element freq is no 0, find its product of 2(value  * 2)
            while(freq != 0)
            {
                //if the the current value product exist in the map, then insert the current value in the result array  
                if(numbers.containsKey(value * 2))
                {
                    //exceptional case for zero(since 0 * number = 0)
                    if(numbers.get(value * 2) != 0)
                    {
                        if(value == 0 && numbers.get(value * 2) <= 1)
                            return new int[]{};
                        
                        //decrease its frequency as its already used
                        numbers.put(value * 2, numbers.get(value * 2) - 1);
                        result[i] = value;
                    }
                    //else it has no original array 
                    else
                        return new int[]{};
                }
                
                //the same here
                else
                    return new int[]{};
                
                //increment index
                i++;
                //decrease current value freq as its used already 
                numbers.put(value, numbers.get(value) - 1);
                //udpate freq
                freq = entry.getValue();
            }
        }
        
        //return the original array
        return result;
    }
}