class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        
        //result array
        int[] answer = new int[queries.length];
        
        //prefixXOR
        int[] preCalcResult = new int[arr.length];
        
        //intialize it
        preCalcResult[0] = arr[0];
        
        //calculate the prefixXOR like prefixSUM
        for(int i=1; i<preCalcResult.length; i++)
            preCalcResult[i] = preCalcResult[i-1] ^ arr[i];
        
        //iterate through the query
        for(int i=0; i<queries.length; i++)
        {
            //if the range dosent start form the 0th index, then calculate this: retrieve the prefixXOR of preCalcResult[queries[i][1]] and discard preCalcResult[queries[i][0] - 1](prefixXOR before the range start) by XORing those two values
            if(queries[i][0] != 0)
                answer[i] = preCalcResult[queries[i][1]] ^ preCalcResult[queries[i][0] - 1];
            
            //otherwise since we already calculated the XOR upto the queries[i][1](range final), we sote that value
            else
                answer[i] = preCalcResult[queries[i][1]]; 
        }
        
        //return the result array
        return answer;
    }
}
