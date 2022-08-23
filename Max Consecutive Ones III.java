class Solution {
    public int longestOnes(int[] nums, int k) {
        
        //two pointers - sliding window technique, max_number - maximum number of consecutive 1's
        int windowStart = 0, windowEnd = 0, max_number = Integer.MIN_VALUE;
        
        //current zero counter
        int zeroes_counter = 0;

        //to check if extra 0 is found( amount of zero > k)
        boolean isExtraFound = false;
        
        //iterate throguh the array with two pointers
        while(windowEnd < nums.length)
        {
            //if the current element is 0 and if extra 0 is not found, then increase amount zerocounter
            if(nums[windowEnd] == 0 && !isExtraFound)
                zeroes_counter++;
            
            //if current amount of zero is less or equal to k, then slide the window(windowEnd) and make isExtraFound false to make sure no extra zeroes are found 
            if(zeroes_counter <= k)
            {
                windowEnd++;
                isExtraFound = false;
            }
            
            //else, calculate the max number of consecuitive 1's and slide the window(windowStart)
            else
            {
                max_number = Math.max(max_number, windowEnd - windowStart);
                
                //if the left element in the window was 0 then decrease zero counter 
                if(nums[windowStart] == 0)
                    zeroes_counter--;
                windowStart++;
                
                //make sure extra zero is found
                isExtraFound = true;
            }            
        }
        
        //calculate the final maximum number of consecutive 1's 
        max_number = Math.max(max_number, windowEnd - windowStart);
        
        //return the result
        return max_number;
    }
}