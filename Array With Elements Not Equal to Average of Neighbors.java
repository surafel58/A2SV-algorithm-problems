class Solution {
    public int[] rearrangeArray(int[] nums) {
        // result array
        int[] result = new int[nums.length];
        
        //sort the nums array
        Arrays.sort(nums);
        
        //(i and j: two pointers, k: to index the result array, n: nums length)
        int i=0, j = nums.length - 1, k=0, n = nums.length;
        
        //add the values from nums to result in such a way that, result[i] left and right neighbors are larger than it or smaller, this is achieved through adding the values into result alternatively(smaller then larger elements from the nums array) 
        while(k<n)
        {
            result[k] = nums[i];
            i++;
            
            if(i<=j)
            {
                result[++k] = nums[j];
                j--;
            }
            k++;
        }     
        
        //return the result array
        return result;
    }
}