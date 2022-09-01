class Solution {
    public void rotate(int[] nums, int k) {
        
        //to store rotated array
        int[] result = new int[nums.length];
        
        //two pointers
        int index1 = 0, index2 = nums.length-1;
        
        //two pointers to store elements in rotated manner in the result array
        int l = k - 1, r=l+1;
        
        //if only one element or rotation step is the same with array length, the array will not change arrangment 
        if(k == nums.length || nums.length == 1)
            return;
        
        //if the rotation step is more than array length, find the equivalent rotation steps with the current k (k = 1 equals k = 6 for length = 5)
        if(k > nums.length)
        {
            if(k % nums.length == 0)
                k = nums.length;
           
            else
            {
                int temp1 = k, temp2 = k;
                
                while(temp1 % nums.length!=0)
                    temp1++;

                while(temp2 % nums.length!=0)
                    temp2--;
                k = Math.abs(Math.min(temp1,temp2) - k);
            }
            
            l = k - 1;
            r=l+1;//r = k
        }
        
        while(r < nums.length)
        {
            //put the rotated elements in their poisition 
            if(l >= 0)
            {
                result[l] = nums[index2];
                index2--;
                l--;
            }
            
            //put the rest of the elements in the remaining slot
            else
            {
                result[r] = nums[index1];
                index1++;
                r++;
            }
        }
            
        // copy result to nums array
        for(int i=0; i<nums.length; i++)
            nums[i] = result[i];
    }
}