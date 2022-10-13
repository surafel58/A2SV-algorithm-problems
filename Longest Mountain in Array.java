class Solution {
    public int longestMountain(int[] arr) {
        
        //complexity - time = n + constants = O(n), space - O(1)
        
        //if length is less return 0
        if(arr.length < 3)
            return 0;
        
        //two pointers, and maxLength of mountain subarray
        int left = 1, right = 1, maxLen = 0;
        
        //iterate through the array from 1 upto length - 2
        for(int i=1; i < arr.length-1; i++)
        {
            //if its the second element, then adjust the right and left pointer until the two conditions are violated
            if(i == 1)
            {
                while(left >= 1 && arr[left-1] < arr[left])
                    left--;
                
                while(right < arr.length-1 && arr[right] > arr[right+1])
                    right++;      
            }
            
            //otherwise for the other elements just check 3 conditions
            else
            {
                //check if the current element violate the 1st condition, then move the left pointer to i 
                if(arr[i-1] >= arr[i])
                    left = i;
                
                //if right pointer to the left of i, then we have to move the right pointer to the right until it violates the 2nd condition
                if(right <= i)
                {
                    right = i;
                    
                    while(right < arr.length-1 && arr[right] > arr[right+1])
                        right++;
                }
            }
                
            //store the maximum length if the current subarray contained between (left and right) is a mountain subarray 
            if(left != i && right != i)
                maxLen = Math.max(maxLen, right - left + 1);
        }
        
        //return the max length
        return maxLen;
    }
}
