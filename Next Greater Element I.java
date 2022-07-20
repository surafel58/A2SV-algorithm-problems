class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //result array
        int []ans = new int[nums1.length];
        
        //set all elements of the ans to -1
        for(int i=0; i<nums1.length; i++)
            ans[i] = -1;
        
        //monotonic stack(decreasing)
        Stack<Integer> mono_stack = new Stack<>();
        
        //store next greater element of all elements 
        int[] output = new int[nums2.length];
        
        //push index of first element 
        mono_stack.push(0);
        
        //iterate through the array and assign the next greater element for each corresponding element 
        for(int i=1; i<nums2.length; i++)
        {
            //if greater element is found and put it in the output array for the given index from the stack, and pop the index 
            while(!mono_stack.empty() && nums2[mono_stack.peek()] < nums2[i])
            {
                output[mono_stack.peek()] = nums2[i];
                mono_stack.pop();
            }
            
            //push index 
            mono_stack.push(i);
        }
        
        //choose the needed ouput 
        for(int i=0; i<nums1.length; i++)
        {
            int index = indexOf(nums2, nums1[i]);
            if(output[index] != 0)
                ans[i] = output[index];
        }
        
        //return the result
        return ans;
    }
    
    //define function to find index of an element  
    private static int indexOf(int[] array, int element){
        for(int i=0; i<array.length; i++)
        {
            if(array[i]==element)
                return i;
        }
        return -1;
    }
}
