class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        int[] result = new int[k];
        
        
        if(nums.length==1)
            return nums;
        
        PriorityQueue<Node> maxHeap = new PriorityQueue<Node>(Collections.reverseOrder());

        //hashmap for storing value as a key with its frequency as its value
        HashMap<Integer, Integer> numbers = new HashMap<>();
        
        //copy the values into hashmap with it freq
        for(int i: nums)
        {
            if(numbers.get(i) == null)
                numbers.put(i, 0);
            numbers.put(i, numbers.get(i)+1);
        }        
        
        //copy the elements from the array to the max heap
        // Iterating HashMap through for loop
        for (Map.Entry<Integer, Integer> set : numbers.entrySet())
            maxHeap.add(new Node(set.getKey(),set.getValue()));
        
        //iterate through the max heap and pop out the largest element until we reach kth largest element 
        for(int i = 0; i < k; i++)
            result[i] = maxHeap.poll().no;
        
        //return result
        return result;
    }
}

//class to store node and its frequency 
class Node implements Comparable<Node>
{
    int no;
    int freq;
    
    public Node(int no, int freq)
    {
        this.no = no;
        this.freq = freq;
    }
    
    public int compareTo(Node e){  
       if(this.freq==e.freq)  
          return 0;  
       else if(this.freq > e.freq)  
          return 1;  
       else  
          return -1;  
    }
}