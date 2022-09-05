class NumMatrix {
    int[][] matrix;
    
    int[][] prefixSum;
    public NumMatrix(int[][] matrix) {
        
        prefixSum = new int[matrix.length][matrix[0].length];
        
        //copy first row values 
        for(int i=0; i<prefixSum[0].length; i++)
            prefixSum[0][i] = matrix[0][i];
        
        //sum up column wise with corresponding matrix element
        for(int i=1; i<prefixSum.length; i++)
        {
            for(int j=0; j<prefixSum[0].length; j++)
                prefixSum[i][j] = matrix[i][j] + prefixSum[i-1][j];
        }
        
        //sum up row wise
        for(int i=0; i<prefixSum.length; i++)
        {
            for(int j=1; j<prefixSum[0].length; j++)
                prefixSum[i][j] += prefixSum[i][j-1];
        }
        
        //initialize
        this.matrix = matrix; 
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        //with one loop
        // for(int i=0; i<matrix.length * matrix[0].length; i++)
        // {
        //     System.out.println(matrix[i/matrix.length][i%matrix[0].length]);
        // }
        
        //calculate region
        int sum = prefixSum[row2][col2];

        if(row1 > 0)
            sum -= prefixSum[row1 -1][col2];
        
        if(col1 > 0)
            sum -= prefixSum[row2][col1-1];
        
        if(row1 > 0 && col1 > 0)
            sum += prefixSum[row1 -1][col1-1];
        
        //return result
        return sum;
    }
    
    
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */