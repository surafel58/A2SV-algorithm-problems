class Solution {
    public int threeSumMulti(int[] arr, int target) {
        
        /*
        main intuition: similar with three sum but consider when left and right values are equal - do some counting using combination formula
        more info - https://leetcode.com/problems/3sum-with-multiplicity/discuss/2494002/Two-Pointer-Solution
        */
        
        Arrays.sort(arr);
        
        int left = 0, middle = left+1, right = arr.length-1, total = 0;
        
        while(left < arr.length - 2)
        {   
            while(middle < right)
            {
                total %= (1000000000 + 7);
                if(arr[left] + arr[middle] + arr[right] < target)
                    middle++;
                else if(arr[left] + arr[middle] + arr[right] > target)
                    right--;
                else
                {
                    int leftCount = 0, rightCount = 0;
                    int leftValue = arr[middle], rightValue = arr[right];
                    
                    if(leftValue == rightValue)
                    {
                        total += ((right - middle + 1) * (right - middle))/2;
                        break;
                    }
                    else
                    {
                        while(leftValue == arr[middle])
                        {
                            leftCount++;
                            middle++;
                        }
                        
                        while(rightValue == arr[right])
                        {
                            rightCount++;
                            right--;
                        }
                        
                        total += (rightCount * leftCount);
                    }
                }
            }
            
            left++;
            middle = left + 1;
            right = arr.length - 1;
        }
                
        return total;
    }
}
