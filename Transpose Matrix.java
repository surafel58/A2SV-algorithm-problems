class Solution {
    public int[][] transpose(int[][] matrix) {

        //result array, with row length == input array colum length and the same with column length of the result array
        int[][] result = new int[matrix[0].length][matrix.length];

        //iterate through the array and simulate the process by arr[j][i] = input[i][j]
        for(int i=0; i < matrix.length; i++)
        {
            for(int j=0; j<matrix[0].length; j++)
                result[j][i] = matrix[i][j];
        }

        //return the result
        return result;

    }
}
