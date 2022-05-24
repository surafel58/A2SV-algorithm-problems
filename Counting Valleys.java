import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
    // Write your code here
    //vraibles that store the amount of Ups and Downs in the path and also valley
    int D=0,U=0,valley=0;
    //variables that store the first and last step of a valley or a mountain
    char first_step = path.charAt(0),last_step=path.charAt(0);
    //iterate through the path and count the number of valleys 
    for(int i=0; i<steps; i++)
    {  
      //if the step is D then increment D else increment U  
       if(path.charAt(i)=='D')
         D++;
       else
         U++;
      //if D == U whcih means the hiker returned to sea level
      if(D==U)
      {
        //make the last step the current step 
        last_step = path.charAt(i);
        //j is used to get the next i value 
        int j = i+1;
        //if first_step == 'D' and last_step== 'U' which means it is a valley then invrement valley  
        if(first_step=='D' && last_step=='U')
            valley++; 
        //if j is out of range then break the loop      
        if(j==steps)
            break;
        //make first_step the next step 
        first_step=path.charAt(j);
        //re assign U and D to 0
        D=0;
        U=0;
      }
    }
    //return calley
    return valley;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}