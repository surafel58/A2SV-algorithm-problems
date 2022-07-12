class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());

        // Creating an iterator
        Iterator value = maxHeap.iterator();
  
        //if array has only 1 element return that element
        if(stones.length == 1)
            return stones[0];
        
        //copy the elements to the heap
         for(int i=0; i<stones.length; i++)
             maxHeap.add(stones[i]);
        
        //iterate throguh the heap until the heap size == 1 or == 0, until then pop the two largest element and if they are not equal then add y-x to the heap
        while(maxHeap.size()>1)
        {
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if(x!=y)
                maxHeap.add(y-x);
        }
        
        //if the heap is empty return 0
        if(maxHeap.size()==0)
            return 0;
        
        //return the remaining element 
        return maxHeap.peek();
        
    }
}