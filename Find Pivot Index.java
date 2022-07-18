class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefixLeftSum = new int[nums.length], prefixRightSum = new int[nums.length];
        
        //if there is only one element then return its index
        if(nums.length==1)
            return 0;
        
        //initialize left prefix sum
        prefixLeftSum[0] = nums[0];
        
        //store the left prefix sum of all elements
        for(int i=1; i<prefixLeftSum.length; i++)
            prefixLeftSum[i] = prefixLeftSum[i-1] + nums[i];
        
        //initialize right prefix sum
        prefixRightSum[0] = prefixLeftSum[prefixLeftSum.length - 1];
        
        //store the right prefix sum of all elements
        for(int i=1; i<prefixRightSum.length; i++)
            prefixRightSum[i] = prefixRightSum[i-1] - nums[i-1];
        
        //iterate through the prefix sums and return the pivot index
        for(int i=0; i<prefixRightSum.length; i++)
        {
            //if left and right prefix sum of the givent element is the same, return its index
            if(prefixLeftSum[i] == prefixRightSum[i])
                return i;
        }
        
        //return -1 if there is not pivot index
        return -1;
    }
}
