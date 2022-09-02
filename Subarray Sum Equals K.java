class Solution {
    public int subarraySum(int[] nums, int k) {
        
        //prefix sum
        int[] prefixSum = new int[nums.length];
        
        //store sum frequencies
        HashMap<Integer,Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);
        
        //i = iterator, counter - count number of subarrayswith sum == k
        int j=0, counter=0;
        
        //calculate prefix sum
        prefixSum[0] = nums[0];
        for(int i=1; i<nums.length; i++)
            prefixSum[i] = nums[i] + prefixSum[i-1];

        //iterate through the prefix sum array and count the subarrays with sum equal to k,
        while(j < nums.length)
        {
            //difference of sum[j] and k
            int temp = prefixSum[j] - k;
            
            //if the diff exists in the hashmap, add the frequency of the prefixsum(diff)
            if(prefixSumMap.containsKey(temp))
                counter += prefixSumMap.get(temp);
            
            //put prefixsum with its frequency in the hashmap
            if(prefixSumMap.get(prefixSum[j]) == null)
                prefixSumMap.put(prefixSum[j], 1);
            else
                prefixSumMap.put(prefixSum[j], prefixSumMap.get(prefixSum[j]) +1);
            
            //increment j
            j++;
        }
        
        //return result
        return counter;
    }
}