class Solution {
    public int minSetSize(int[] arr) {
        if(arr.length == 2)
            return 1;
  
        HashMap<Integer, Integer> numbers = new HashMap<>();
        ArrayList<Integer> Freq = new ArrayList<>();
        
        //copy the values into hashmap with it freq
        for(int i: arr)
        {
            if(numbers.get(i) == null)
                numbers.put(i, 0);
            numbers.put(i, numbers.get(i)+1);
        }
        
        // Getting an iterator
        Iterator itr = numbers.entrySet().iterator();
 
        // Iterating through Hashmap and copy the frequency to the arraylist
        while (itr.hasNext()) {
            Map.Entry mapElement = (Map.Entry)itr.next();
            Freq.add((int)mapElement.getValue());
        }
        
        //initializ some useful variables (sum: the total lengt of array, half_length: half of length, counter: count how many integers are to be deleted)
        int sum = arr.length, half_length = arr.length/2, counter = 0;
        
        //sort the fequency arraylist in reverse order
        Collections.sort(Freq, Collections.reverseOrder());
        
        //iterate through the arraylist and keep decrementing the value with largest frequency from the sum until sum <= half_length
        int i=0;
        while(sum > half_length)
        {
            counter++;
            sum-=Freq.get(i);
            i++;
        }
        
        //return the count
        return counter;
    }
}