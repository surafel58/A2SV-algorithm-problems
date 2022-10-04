class Solution {
    public int maxFrequency(int[] nums, int k) {
        
        //sort the array so that numbers that are closer to each other are put near each other    
        Arrays.sort(nums);
        
        //sliding window technique
        int windowStart = 0, windowEnd = 0, maxLen = Integer.MIN_VALUE;
        long currentSum = 0;
        
        //to check if the window has increase its size
        boolean valid = true;
        
        //solve the current values max frequency and store the max length of the window for each iteration  
        while(windowEnd < nums.length)
        {
            //if the window increased size, add the right element(special value where its value is going to be replicated)
            if(valid)
                currentSum += nums[windowEnd];
            
            //check if we can make the numbers before the current element(windowEnd element) the same with it.
            //we do that by calculating the sum when all the elements before the special value is the same with it, and check if we have enough K to bring the currentSUm to the one that is calculated.  
            if((long)nums[windowEnd] * (windowEnd - windowStart + 1) <= currentSum + k)
            {
                valid = true;
                windowEnd++;
            }
            
            //else sotre the max length
            else
            {
                maxLen = Math.max(maxLen, windowEnd - windowStart);
                currentSum -= nums[windowStart];
                windowStart++;
                valid = false;
            }
        }
        
        maxLen = Math.max(maxLen, windowEnd - windowStart);
        
        //return the max length which is the same as the maximum frequency 
        return maxLen;
    }
}
