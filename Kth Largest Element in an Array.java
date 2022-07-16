class Solution {
    public int findKthLargest(int[] nums, int k) {
        //max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        //if tehre is one element return that element
        if(nums.length==1)
            return nums[0];
        
        //copy the elements from the array to the max heap
        for(int i=0; i<nums.length; i++)
            maxHeap.add(nums[i]);
        
        //temporary variable to store the largest number from the heap
        int x = maxHeap.peek();
        
        //iterate through the max heap and pop out the largest element until we reach kth largest element 
        for(int i = 0; i < k; i++)
            x = maxHeap.poll();
        
        //return the kth largest element
        return x;
    }
}