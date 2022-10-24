class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        
        /*
        turn the interval addition into cumulative sum. But why? Because by turning [st, end, k] into cumulative sum we don't need to care the start and the end of the interval and the overlaps between the intervals, now the problem becomes how to turn the single interval addition [st, end, k] into cumulation will only increase the numbers in the interval [st, end] but not those outside the interval.

By adding k -the initial culmulative- to the first of the interval st, if we do culmulative sum among the later numbers, we will get [+k, +k, ..] until the end of the array. In order to let the culmulative sum stops at the index end. we can set an initial culmulative value -k at end+1 like below:

        main intuition:  just put checkpoints (-k) after each end index of bookings[i], then just add result[i] with result[i-1]  
        */
        
        //prefix Sum
        int[] result = new int[n];
        
        for(int[] booking : bookings)
        {
            result[booking[0]-1] += booking[2];
            
            if(booking[1] < n)
                result[booking[1]] -= booking[2];
        }
        
        for(int i=1; i<n; i++)
            result[i] += result[i-1];
        
        return result;
    }
}
