class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        
        if(tokens.length == 0)
            return 0;
        
        int score = 0;
        int i1 = 0, i2 = tokens.length-1;
        
        //sort the array
        Arrays.sort(tokens);
        
        while(i1 != i2)
        {
            //if the left element is <= power, then play token face up(token[i1])
            if(tokens[i1] <= power)
            {
                power -= tokens[i1];
                i1++;
                score++;
            }
            
            //else if the right element is > power, and if score is at least 1, then play token face down(token[i2])
            else if(tokens[i2] > power && score > 0)
            {
                power += tokens[i2];
                i2--;
                score--;
            }
            
            //otherwise return 0
            else
                return 0;
        }
        
        //check for the remaining element if we still can play token face up
        if(tokens[i1] <= power)
            score++;
        
        //return result
        return score;
    }
}
