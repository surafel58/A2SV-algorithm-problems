class Solution {
    public int longestSubarray(int[] nums) {
        
        //sliding window technique, counter - zeero counter in the current window
        int windowStart = 0, windowEnd = 0, maxLen = 0, counter = 0;
        
        //iterate through the array and keep at most 1 zero in the window size, but if another 0 is found calculate the current window size length without the previous zero and shrink window until previous 0 is removed then grow windowsize. 
        while(windowEnd < nums.length)
        {
            
            //if there is already one zero in the window 
            if(nums[windowEnd] == 0 && counter == 1)
            {
                maxLen = Math.max(maxLen, windowEnd - windowStart - 1);
                while(counter != 0)
                {
                    if(nums[windowStart] == 0)
                        counter--;
                    
                    windowStart++;
                }
            }
            else
            {
                //increment counter when 0 is found
                if(nums[windowEnd] == 0 && counter == 0)
                    counter++;
                windowEnd++;
            }
        }
        
        //calculate maxlen for the last time  
        maxLen = Math.max(maxLen, windowEnd - windowStart - 1);
        
        //return maximum length
        return maxLen;
    }
}
