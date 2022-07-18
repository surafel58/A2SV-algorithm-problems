class Solution {
    public int[] productExceptSelf(int[] nums) {
        //array to store the result
        int[] answer = new int[nums.length];
        
        //array to store the prefix product of nums array
        int[] prefixProduct = new int[nums.length];
        
        //array to store the suffixproduct of nums array
        int[] suffixProduct = new int[nums.length];
        
        //initialize the prefix product
        prefixProduct[0] = 1;
        
        //calculate the prefix product 
        for(int i=1; i<prefixProduct.length; i++)
            prefixProduct[i] = prefixProduct[i-1] * nums[i-1];
        
        //reverse the nums array to calculate the suffix prodcut as a prefix product for the reversed nums array
        reverse(nums, nums.length);
        
        //initialize the suffix product
        suffixProduct[0] = 1;
        
        //calculate the prefix product for the reversed array(suffix product for the nums array before reversed) 
        for(int i=1; i<suffixProduct.length; i++)
            suffixProduct[i] = suffixProduct[i-1] * nums[i-1];
        
        //calculate product of for each element except its self by multiplying the prefix and suffix product
        for(int i=0; i<answer.length; i++)
            //the suffix product is reversed so we should start from the end
            answer[i] = prefixProduct[i] * suffixProduct[(answer.length - 1) - i];
        
        //return the result
        return answer;
    }
    
    //function to reverse an array 
    public void reverse(int a[], int n)
    {
        int i, k, t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
    }
}