class Solution {
    public void nextPermutation(int[] nums) {
        
        //edge case
        if(nums.length == 1)
            return;
        
        //useed two pointers( must start from the end of array)
        int left = nums.length - 2, right = nums.length - 1;
        
        //find the greater element or peek (nums[right] > nums[left]) starting from end of array
        while(right >= 1 && nums[right] <= nums[left])
        {
            right--;
            left--;
        }
        
        
        //Then check if another greater element is found to the right of the current greater element found(find greater numbers yet with lower terms)
        while(left >= 0 && right < nums.length && nums[right] > nums[left])
            right++;
        
        right--;
        
        //swap left and right and sort the rest of the sub array from the right of the left 
        if(left >= 0)
        {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            bubbleSort(nums, left+1);
        }
        
        //bubble sort
        else
            bubbleSort(nums, 0);
    }
    
    public void bubbleSort(int arr[], int k)
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = k; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }
}
