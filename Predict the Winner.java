class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return (findWinner(nums, 0, nums.length-1, true) >= 0);
}
    
    public int findWinner(int[] nums, int i, int j, boolean turn)
    {
        if(i==j)
        {
            if(turn)
                return nums[i];

            return (-1 * nums[i]);
        }

        int a = nums[i];
        int b = nums[j];

        if(turn == false)
        {
            a*=-1;
            b*=-1;
        }

        a += findWinner(nums, i+1, j, !turn);
        b += findWinner(nums, i, j-1, !turn);

        if(turn)
            return Math.max(a,b);

        return Math.min(a,b);
}
    
}