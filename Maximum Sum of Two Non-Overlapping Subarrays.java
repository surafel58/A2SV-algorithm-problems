class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        
        //sliding window technique
        int windowStart1 = 0, windowEnd1 = 0, max_sum = Integer.MIN_VALUE, current_sum1 = 0;
        
        //
        int windowStart2 = 0, windowEnd2 = 0, current_sum2 = 0;
        
        //calculate max sum, by going through each non ovelaping subarray
        while(windowEnd2 < nums.length)
        {
            //add current sum
            current_sum2 += nums[windowEnd2];
            
            //if desired length is reached calculate the max sum for each subarray using sliding window 
            if(windowEnd2 - windowStart2 + 1 >= firstLen)
            {
                
                windowEnd1 = windowStart1 = (windowEnd2 + 1);
                current_sum1 = 0;
                
                //calculate max sum of the subarays(to the right subarrays) for the current subarray1
                while(windowEnd1 < nums.length)
                {
                    
                    current_sum1 += nums[windowEnd1];
                    
                    if(windowEnd1 - windowStart1 + 1 >= secondLen)
                    {
                        
                        //store max_sum of the sum(first subarray and second subarray)
                        max_sum = Math.max(max_sum, current_sum1 + current_sum2);
                        current_sum1 -= nums[windowStart1];
                        windowStart1++;
                    }
                    
                    windowEnd1++;
                }
                
                //consider the left subarrays also
                windowEnd1 = windowStart1 = (windowStart2 - 1);
                current_sum1 = 0;
                
                while(windowEnd1 >= 0)
                {
                    current_sum1 += nums[windowEnd1];
                    if(windowStart1 - windowEnd1 + 1 >= secondLen)
                    {
                        max_sum = Math.max(max_sum, current_sum1 + current_sum2);
                        current_sum1 -= nums[windowStart1];
                        windowStart1--;
                    }
                    windowEnd1--;
                }
                
                current_sum2 -= nums[windowStart2];                
                windowStart2++;
            }
            windowEnd2++;
        }


        //return the max sum
        return max_sum;
    }
}
