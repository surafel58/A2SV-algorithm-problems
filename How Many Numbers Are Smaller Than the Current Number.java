class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        //count the smaller numbers of a given current number
        int count=0;
        //array to store the frequency of the smaller numbers of each numbers in the nums array
        int []result = new int[nums.length];
        //iterate over the array to count the smaller numbers of each numbers 
        for(int i=0; i<nums.length; i++)
        {
            for(int j=0; j<nums.length; j++)
            {
                //if the indices are equal continue to the next iteration
                if(j==i)
                    continue;
                //if the number is smaller than the current number, increment count
                if(nums[j] < nums[i])
                    count++;
            }
            //store the result of count for the current number 
            result[i] = count;
            count=0;
        }
        return result;
    }
}