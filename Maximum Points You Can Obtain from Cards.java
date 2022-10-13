class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        //sliding window technique
        int windowStart = 0, windowEnd = 0, maxScore = 0, currentScore = 0;
        
        //total sum of array
        int totalSum = 0;
        for(int i=0; i<cardPoints.length; i++)
            totalSum += cardPoints[i];
        
        
        //if k == n, then add all the elements 
        if(k == cardPoints.length)
            return totalSum;
        
        
        //iterate through the array by removing subarray with n-k(we will be left with k elements)
        while(windowEnd < cardPoints.length)
        {
            //add current score
            currentScore += cardPoints[windowEnd];
            
            //if subarray of size n-k is found, then store the maximum score so far(which is max(maxScore, remaining score when we remove this current subarray of sie n-k))
            if(windowEnd - windowStart + 1 == cardPoints.length - k)
            {
                maxScore = Math.max(maxScore, totalSum - currentScore);
                currentScore -= cardPoints[windowStart];
                windowStart++;
            }
            
            //increase window size
            windowEnd++;
        }

        //return maxscore
        return maxScore;
    }
}
