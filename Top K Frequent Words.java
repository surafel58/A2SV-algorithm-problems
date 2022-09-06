class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        ArrayList<String> result = new ArrayList<>();
        
        if(words.length==1)
            return Arrays.asList(words);
        
        PriorityQueue<Node> maxHeap = new PriorityQueue<Node>(Collections.reverseOrder());

        //hashmap for storing value as a key with its frequency as its value
        HashMap<String, Integer> numbers = new HashMap<>();
        
        //copy the values into hashmap with it freq
        for(String i: words)
        {
            if(numbers.get(i) == null)
                numbers.put(i, 0);
            numbers.put(i, numbers.get(i)+1);
        }        
        
        //copy the elements from the array to the max heap
        // Iterating HashMap through for loop
        for (Map.Entry<String, Integer> set : numbers.entrySet())
            maxHeap.add(new Node(set.getKey(),set.getValue()));
        
        //iterate through the max heap and pop out the largest element until we reach kth largest element 
        for(int i = 0; i < k; i++)
            result.add(maxHeap.poll().word);
        
        //return result
        return result;
    }
}

//class to store node and its frequency 
class Node implements Comparable<Node>
{
    String word;
    int freq;
    
    public Node(String word, int freq)
    {
        this.word = word;
        this.freq = freq;
    }
    
    public int compareTo(Node e){  
       if(this.freq == e.freq)  
          return -(this.word.compareTo(e.word));  
       else if(this.freq > e.freq)  
          return 1;  
       else  
          return -1;  
    }
}