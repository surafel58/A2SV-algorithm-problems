class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        
        //store list of days
        ArrayList<Integer> list_of_days = new ArrayList<>();
        
        //prefix and suffix count of contigious decreasing element
        int[] pre = new int[security.length];
        int[] suff = new int[security.length];
        
        //initilaize
        pre[0] = 0;
        suff[security.length-1] = 0;

        //to count number of decreasing element so far
        int counter=0;
        
        //iterate through the array and keep counting the decreasing element and add it to pre array, if increasing element is found, then restart count to 0 
        for(int i=1; i < security.length; i++)
        {
            if(security[i] <= security[i-1])
                counter++;
            else
                counter = 0;
            
            pre[i] = counter;
        }
        
        counter = 0;
        
        //the same here, but it start from the end of the array
        for(int i=security.length - 2; i >= 0; i--)
        {
            if(security[i] <= security[i+1])
                counter++;
            else
                counter = 0;
            
            suff[i] = counter;
        }
        
        //then check for prefix and suffix count of decreasing days that are >= time and add the index to the list
        for(int i=0; i < security.length; i++)
        {
            if(pre[i] >= time && suff[i] >= time)
                list_of_days.add(i);
            
        }
        
        //return the result
        return list_of_days;
    }
}