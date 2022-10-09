class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        
        //prefixSum
        long[] prefixSum = new long[chalk.length];
        
        prefixSum[0] = chalk[0];
        for(int i=1; i<prefixSum.length; i++)
            prefixSum[i] = chalk[i] + prefixSum[i-1];
        
        //store the total needed chalk pieces
        long p = prefixSum[prefixSum.length-1];
        
        //sotre the maximum valid amount of total chalk pieces that can be used upto k      
        p = k/p * p;
        
        //if total needed chalk pieces is more than k, just find for sum[j] > k 
        if(p == 0)
        {
            int j=0; 
            while(k >= prefixSum[j])
                j++;
            return j;
        }
        
        //otherwise, check for the remaining amount of chalk pieces(temp < sum[j]): which is find the index where more than remaining amount of chalk pieces is needed.
        else
        {
            long temp = k - p;
            int j=0; 
            while(temp >= prefixSum[j])
                j++;
            return j;
        }
    }
}
