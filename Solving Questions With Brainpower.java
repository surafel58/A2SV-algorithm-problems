class Solution {
    
    //dynamic programming
    //twp options for single question - solve it or leave it,
    //memoize the points of already known max points for a question
    HashMap<Integer,Long> memo = new HashMap<>();
    public long mostPoints(int[][] questions) {
        return solveQ(questions, 0);
    }
    
    public long solveQ(int[][] questions, int i)
    {
        if(i >= questions.length)
            return 0;
        
        if(memo.containsKey(i))
            return memo.get(i);
        else
        {
            long Qin = questions[i][0] + solveQ(questions, i + questions[i][1] + 1);
            long Qout = solveQ(questions, i+1);
            memo.put(i, Math.max(Qin, Qout));
            return Math.max(Qin, Qout);
        } 
    }
}
