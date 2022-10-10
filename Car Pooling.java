class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // return false;
        java.util.Arrays.sort(trips, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });
        
        for(int i=0; i < trips.length; i++)
        {
            if(i == 0)
            {
                if(capacity >= trips[i][0])
                    capacity -= trips[i][0];
                else
                    return false;
            }
            
            else
            {
                //minheap
                for(int j = i-1; j >= 0; j--)
                {
                    if(trips[i][1] >= trips[j][2])
                        capacity += trips[j][0];
                }
                
                if(capacity >= trips[i][0])
                    capacity -= trips[i][0];
                else
                    return false;
            }
        }
        return true;
    }
}
