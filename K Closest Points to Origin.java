class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        //if size 1 return the point
        if(points.length == 1)
            return points;
        
        double[][] distance = new double[points.length][2];
        
        //calculate distance and store it with its corresponding index in 2d array
        for(int i=0; i<points.length; i++)
        {
            distance[i][0] = calculateD(points[i][0], points[i][1]);
            distance[i][1] = i;
        }
        
        //sort 
        sortbyColumn(distance);
        
        for(int i=0; i<k; i++)
        {
            result[i][0] = points[(int)Math.round(distance[i][1])][0];
            result[i][1] = points[(int)Math.round(distance[i][1])][1];
        }
        
        //return the result
        return result;
    }
    
    //calculate distance
    public double calculateD(int x, int y)
    {        
        double result = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
        return result;
    }
    
    // Function to sort 2d array by column
    public void sortbyColumn(double arr[][])
    {
        // Using built-in sort function Arrays.sort
        Arrays.sort(arr, new Comparator<double[]>() {
            
          @Override              
          // Compare values according to columns
          public int compare(final double[] entry1, 
                             final double[] entry2) {
  
            // To sort in descending order revert 
            // the '>' Operator
            if (entry1[0] > entry2[0])
                return 1;
            else
                return -1;
          }
        });  // End of function call sort().
    }
}