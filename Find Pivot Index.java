class Solution {
    public int pivotIndex(int[] nums) {
        //variables to store the summation of left and right from the given index
        int leftsum=0, rightsum=0;
        //iterate through the array to find th epivot index
        for(int i=0; i<nums.length; i++)
        {
            //calculate the leftsum for the current index
            for(int j=i-1; j!=-1; j--)
                leftsum+=nums[j];
            
            //calculate the rightsum
            for(int k=i+1; k<nums.length; k++)
                rightsum+=nums[k];
            
            //if the left sum and right sum are equal for the current index then it is the pivot index
            if(leftsum==rightsum)
                return i;
            
            //reinitialize the leftsum and rightsum for the next index to be checked if it is pivot index
            leftsum=0;
            rightsum=0;
        }
        //if not found return -1
        return -1;
    }
}