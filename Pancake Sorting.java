class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        //I used pancake sorting 
        ArrayList<Integer> list_of_k = new ArrayList<>();
        
        int j = arr.length-1;
        
        while(j >= 0)
        {
            //find max
            int max = findMax(arr, 0, j);
            
            //reverse arr upto max
            reverse(arr, 0, max);
            
            //add the k values
            list_of_k.add(max+1);
            
            //reverse arr upto j
            reverse(arr, 0, j);
            
            //add the k values
            list_of_k.add(j+1);
            
            //decrement
            j--;
        }
        
        //return result
        return list_of_k;
    }
    
    public int findMax(int[] arr, int i, int j)
    {
        int max = i;
        
        for(int k = i+1; k <= j; k++)
        {
            if(arr[max] < arr[k])
                max = k;
        }
        
        return max;
    }
    
    public void reverse(int[] arr, int i, int j)
    {
        int p1 = i, p2 = j;
        
        while(p1 < p2)
        {
            int temp = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = temp;
            p1++;
            p2--;
        }
    }
}