///solution with sliding window
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE, current_sum = 0, windowStart = 0, windowEnd = 0;
        
        while(windowEnd < nums.length)
        {
            current_sum += nums[windowEnd];
            while(current_sum >= target)
            {
                
                min = Math.min(min, windowEnd - windowStart + 1);
                current_sum -= nums[windowStart];
                windowStart++;
            }
            windowEnd++;
        }
        
        min = Math.min(min, windowEnd - windowStart + 1);
        if(min == nums.length + 1)
            return 0;
        return min;
    }
}
