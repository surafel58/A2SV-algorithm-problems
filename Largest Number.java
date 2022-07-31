class Solution {
    public String largestNumber(int[] nums) {
        //string array 
        String[] strnum = new String[nums.length];
        
        //convert the number to string and store it in strnum array
        for(int i=0; i<nums.length; i++)
            strnum[i] = String.valueOf(nums[i]);
        
        //sort the string array based on custom comparator
        Arrays.sort(strnum, (a,b) -> (b+a).compareTo(a+b));
        
        //string buffer
        StringBuffer result = new StringBuffer();
        
        //concatinate the strings to resut  
        for(int i=0; i<nums.length; i++)
            result.append(strnum[i]);
        
        //if the leading number is "0" then return 0
        if(result.charAt(0) == '0')
            return "0";
        
        //return the result
        return result.toString();
    }
}