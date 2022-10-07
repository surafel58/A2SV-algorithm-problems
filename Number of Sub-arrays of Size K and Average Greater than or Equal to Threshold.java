class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int windowStart = 0, windowEnd = 0, currentSum = 0, counter =0;;
        
        while(windowEnd < arr.length)
        {
            currentSum += arr[windowEnd];
            if(windowEnd - windowStart + 1 >= k)
            {
                int avg = currentSum/k;
                if(avg >= threshold)
                    counter++;
                currentSum -= arr[windowStart];
                windowStart++;
            }
            windowEnd++;
        }
        return counter;
    }
}
