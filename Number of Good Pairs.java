class Solution {
    public int numIdenticalPairs(int[] nums) {
        //counter for counting good pairs
        int counter=0;
        //iteratre through the array to find good pairs
        for(int i=0; i<nums.length; i++)
        {
            for(int j=0; j<nums.length; j++)
            {
                //if the j and i are the same index or i > j (i.e - i cannot be greater than j (i,j)), continue.
                if(j==i||i>j)
                    continue;
                //increment counter if good pairs are found
                if(nums[i]==nums[j])
                    counter++;
            }
        }
        //return counter
        return counter;
    }
}