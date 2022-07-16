class Solution {
    public int kthSmallest(int[][] matrix, int k) {
              
        int rows = matrix.length, columns=rows;
        
        //sort the array
        heapSort(matrix, matrix.length * matrix.length);
        
        rows = matrix.length;
        columns = rows;

        //iterate through the array until the kth smallest element is found 
        int n=0,result=0;
        for (int i = 0; i < rows * columns && n<k; i++, n++) {
 
            // Find row and column index
            int row = i / columns;
            int col = i % columns;

            result=matrix[row][col];
        }
        
        //return the kth element
        return result;
        
    }
    
    //Function to build a Heap from array.
    void buildHeap(int arr[][], int n)
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
    void heapify(int arr[][], int n, int i)
    {
        // Your code here
        //store index of left and right child 
        int left = 0, right = 0, temp;
        //store the index of the maximum element from the parent and its children
        int max=i, r=arr.length;

        //check if there exist a child node for the given parent
        if((2*i + 1) < n)
            left = 2*i + 1;
        
        if((2*i + 2) < n)
            right = 2*i + 2;
        
        //check if the parent is less than from its children and assign max the index of the maximum element from the parent, left or right child 
        
        if((arr[i/r][i%r] < arr[left/r][left%r]) && left!=0)
            max=left;
            
        
        if((arr[max/r][max%r] < arr[right/r][right%r]) && right!=0)
            max=right;
            
        
        //if the maximum element is not the parent then make the parent the maximum element     
        if(max!=i)
        {
            //swap the parent with one of the child which is max
            temp = arr[i/r][i%r];
            arr[i/r][i%r] = arr[max/r][max%r];
            arr[max/r][max%r] = temp;
            
            //call heapify recursively to put the current element in its proper place 
            heapify(arr, n, max);
        }
    }
    
    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[][], int n)
    {
        //code here
        //build a heap
        buildHeap(arr, n);
        int temp, r=arr.length;
        //iterate through the heap and swap the fisrt element with the last element of the unsorsted part of the array and then heapify the unsorted elements, as a result it will start sorting it self from the end  
        for(int i=n-1; i>0; i--)
        {
            temp = arr[i/r][i%r];
            arr[i/r][i%r] = arr[0][0];
            arr[0][0] = temp;
            
            heapify(arr, i, 0);
        }
    }
}