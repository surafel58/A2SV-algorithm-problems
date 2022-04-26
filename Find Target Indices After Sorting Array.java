class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        //list to store the indices of the numbers that match the target
        ArrayList<Integer> result = new ArrayList<>();
        //sorting the array
        Arrays.sort(nums);
        //iterating over the array to find numbers that match the target
        for(int i=0; i<nums.length; i++)
        {
            //if match found, store the index
            if(nums[i]==target)
                result.add(i);
        }
        //return the list of indices of the numbers that match the target
        return result;
    }
}