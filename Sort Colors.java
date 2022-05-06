class Solution {
    public void sortColors(int[] nums) {
        //using insertion sort
        int temp;
        for(int i=1; i<nums.length; i++)
        {
            temp = nums[i];
            for(int j=i; j>0; j--)
            {
                if(temp < nums[j-1])
                {
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
                else
                    break;
            }
        }
    }
}