class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int []ans = new int[nums1.length];
        //set all elements of the ans to -1
        for(int i=0; i<nums1.length; i++)
            ans[i] = -1;
        //itearte through nums1 to find the next greater element for each nums1[i]
        for(int i=0; i<nums1.length; i++)
        {
            //store the index of nums[i] from nums2 array
            int index = indexOf(nums2,nums1[i]);
            //iterate through nums2 array to find next greater element of the given element
            for(int j=index; j<nums2.length-1; j++)
            {
                //if found put it in the ans array, and break out of the inner loop 
                if(nums2[index]<nums2[j+1])
                {
                    ans[i] = nums2[j+1];
                    break;
                }    
            }
        }
        //return the array
        return ans;
    }
    
    //define function to find index of an element  
    private static int indexOf(int[] array, int element){
        for(int i=0; i<array.length; i++)
        {
            if(array[i]==element)
                return i;
        }
        return -1;
    }
}