class Solution {
    public int minIncrementForUnique(int[] nums) {
        //store previous max number, and counter that count the moves 
        int preMax, counter = 0;
        
        //sort array
        Arrays.sort(nums);
        
        //initialize preMax
        preMax = nums[0];
        
        //iterate through the array and keep track of previous max element
        for(int i=1; i<nums.length; i++)
        {
            //if preMax < nums[i] then store the max number on the premax
            if(preMax < nums[i])
                preMax = nums[i];
            
            //else, increment premax and assign the premax to current element and increment counter
            else if(preMax >= nums[i])
            {
                int temp = preMax;
                preMax++;
                if(temp > nums[i])
                    counter += preMax - nums[i];
                else
                    counter++;
                nums[i] = preMax;
            }
        }
        
        //return the number of moves
        return counter;
    }
}
