class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length==1)
            return;
        
        int index1 = 0, index2 = 1, temp;
        //move the two pointers through the array to move all the zeroes at the end, the loop iterates until the second pointer get out of the index bound of the array
        while(index2 < nums.length)
        {
            //if the number pointed by first pointer is 0, then it needs to be moved to the end of the array 
            if(nums[index1] == 0)
            {
                //it will be swapped if the next number is not zero, and then move the two pointers  
                if(nums[index2] !=0)
                {
                    
                    temp = nums[index1];
                    nums[index1] = nums[index2];
                    nums[index2] = temp;
                    
                    index1++;
                    index2++;
                }
                //otherwise, move only the second pointer
                else
                     index2++;
            }
            //if the number pointed by first pointer is not 0, just move the two pointers
            else
            {
                index1++;
                index2++;
            }
        }
    }
}