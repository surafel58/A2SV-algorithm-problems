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
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        //get the last element to be placed in its proper place 
        int last_element = arr.get(n-1);
        //index to iterate over the array 
        int i=n-1;
        //iterate over the array to put the element in its proper place
        for(; i>0; i--)
        {   //check if the given i-1 element is greater than the element to be placed in its proper place 
            if(arr.get(i-1) > last_element)
            {
                arr.set(i, arr.get(i-1));
                for(int j=0; j<n; j++)
                    System.out.print(arr.get(j) + " ");
                System.out.println();       
            }
            //else the proper position is found  
            else
            {
                arr.set(i, last_element);
                for(int j=0; j<n; j++)
                    System.out.print(arr.get(j) + " ");
                System.out.println();
                break;
            }
        }
        //if its proper place is in the first position.
        if(i==0)
        {
            arr.set(0, last_element);
            for(int j=0; j<n; j++)
                System.out.print(arr.get(j) + " ");
            System.out.println();   
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
