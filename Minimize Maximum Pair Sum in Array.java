class Solution {
    public int minPairSum(int[] nums) {
        //sort the array to get the optimal pairs
        Arrays.sort((nums));
        //two pointers
        int index1=0, index2=nums.length-1;
        //to store maximum pair sum from the optimal pairs
        int max = 0;
        //iterate through the array and calculate the sum of the pairs(nums[index1], nums[index2])
        while(index1 < nums.length/2)
        {
            int sum = nums[index1] + nums[index2];
            if(max < sum)
                max = sum;
            index1++;
            index2--;
        }
        
        //return the max pair sum from the optimal pair elements
        return max;
    }
}