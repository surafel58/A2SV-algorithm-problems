class Solution
{
     public int maxSum(int[][] grid)
     {
        int[][] prefixSum = new int[grid.length][grid[0].length];

        int maxSum = 0;

        for(int i=0; i < grid.length; i++)
        {
            for(int j =0; j < grid[0].length; j++)
            {
                if(j == 0)
                {
                    prefixSum[i][0] = grid[i][0];
                }
                else    
                    prefixSum[i][j] = prefixSum[i][j-1] + grid[i][j];
            }
        }

        for(int i = 0; i + 2 < prefixSum.length; i++)
        {
            for(int j = 0; j + 2 < prefixSum[0].length; j++)
            {
                if((i + 2) < prefixSum.length && (j + 2) < prefixSum[0].length)
                {
                    int x1 = 0;
                    int x2 = 0;
                    if(j == 0)
                    {
                        x1 = prefixSum[i][j+2];
                        x2 = prefixSum[i+2][j+2];
                    }
                    else
                    {
                        x1 = prefixSum[i][j+2] - prefixSum[i][j-1];
                        x2 = prefixSum[i+2][j+2] - prefixSum[i+2][j-1];
                    }
                    
                    int currentSum =  x1 + (prefixSum[i+1][j+1] - prefixSum[i+1][j]) + x2;
                    maxSum = Math.max(maxSum, currentSum);
                }
            }
        }
        return maxSum;
     }
} 
