class Solution {
    public int maxOperations(int[] nums, int k) {
        //hashmap for storing value as a key with its frequency as its value
        HashMap<Integer, Integer> numbers = new HashMap<>();
        //copy the values into hashmap with it freq
        for(int i: nums)
        {
            if(numbers.get(i) == null)
                numbers.put(i, 0);
            numbers.put(i, numbers.get(i)+1);
        }
        
        //operation counter
        int operations = 0;   
        
        //iterate through the array and each time pair is found (nums[i], k - nums[i]) and if both exists in the hasmap(freq!=0 and if there is a key called k- nums[i] in the hashmap) then decrement their frequencies and move to next iteration
        for(int i=0; i<nums.length; i++)
        {
            if((numbers.get(nums[i]) != 0) && numbers.containsKey(k - nums[i]) && (numbers.get(k - nums[i]) != 0))
            {
                if(nums[i] == (k - nums[i]) && numbers.get(nums[i]) == 1)
                    continue;
                operations++;
                numbers.put(nums[i], numbers.get(nums[i]) - 1);
                numbers.put(k - nums[i], numbers.get(k - nums[i]) - 1);
            }
        }
        
        //return the amount of operation done
        return operations;   
    }
}