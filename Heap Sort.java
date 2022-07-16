// { Driver Code Starts
import java.util.*;
class Heap_Sort
{
    void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        Heap_Sort hs = new Heap_Sort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
                
            Solution ob=new Solution();
            ob.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }
    
}


// } Driver Code Ends


class Solution
{
    //Function to build a Heap from array.
    void buildHeap(int arr[], int n)
    {
        // Your code here
        //start index = last non leaf node
        int start = n/2 - 1;
        int i = start;
        //iterate througth the heap and heapify all the non-leaf nodes starting from the last non-leaf node upto the root node 
        while(i>=0)
        {
            //heapify 
            heapify(arr, n, i);
            i--;
        }
    }
 
    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i)
    {
        // Your code here
        //store index of left and right child 
        int left = 0, right = 0, temp;
        //store the index of the maximum element from the parent and its children
        int max=i;
        
        //check if there exist a child node for the given parent
        if((2*i + 1) < n)
            left = 2*i + 1;
        
        if((2*i + 2) < n)
            right = 2*i + 2;
        
        //check if the parent is less than from its children and assign max the index of the maximum element from the parent, left or right child 
        if((arr[i] < arr[left]) && left!=0)
            max=left;
        
        if((arr[max] < arr[right]) && right!=0)
            max=right;
        
        //if the maximum element is not the parent then make the parent the maximum element     
        if(max!=i)
        {
            //swap the parent with one of the child which is max
            temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            
            //call heapify recursively to put the current element in its proper place 
            heapify(arr, n, max);
        }
    }
    
    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n)
    {
        //code here
        //build a heap
        buildHeap(arr, n);
        int temp;
        //iterate through the heap and swap the fisrt element with the last element of the unsorsted part of the array and then heapify the unsorted elements, as a result it will start sorting it self from the end  
        for(int i=n-1; i>=0; i--)
        {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            
            heapify(arr, i, 0);
        }
    }
 }
 
 
