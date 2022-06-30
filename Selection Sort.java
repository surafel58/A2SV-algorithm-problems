class Solution
{
    int  select(int arr[], int i)
    {
        // code here such that selectionSort() sorts arr[]
        //select the smallest element from the remaining unsorted subarray and return the value
        int smallest = i;
        for(int j = i+1; j<arr.length; j++)
        {
            if(arr[j] < arr[smallest])
                smallest = j;
        }
        return smallest;
    }
    
    void selectionSort(int arr[], int n)
    {
        //code here
        int smallest, temp;
        //get the smallest value from the remaining unsorted array and put it in its proper place by swapping  
        for(int i=0; i<n; i++)
        {
            smallest = i;
            smallest = select(arr, i);
            temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }
    }
}