class KthLargest {
    //heap
    PriorityQueue<Integer> minHeap;
    //kth number
    int kth_number;
    public KthLargest(int k, int[] nums) {
        //initialie heap
        minHeap = new PriorityQueue<Integer>();
        //add the elements from array to heap
        for(int i=0; i<nums.length; i++)
            minHeap.add(nums[i]);
        
        kth_number=k;
    }
    
    public int add(int val) {
        //add element to the heap
        minHeap.add(val);
        
        //size of heap
        int length = minHeap.size();
        
        // Creating an iterator
        Iterator value = minHeap.iterator();

        // iterating through the queue and deleting element until the length == kth number, so that we can get the kth largest element at the top of the heap  
        while (value.hasNext() && (kth_number!=length)) {
                int x = minHeap.poll();
                length = minHeap.size();
            }
        //return the first element of the heap 
        return minHeap.peek();
        }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */