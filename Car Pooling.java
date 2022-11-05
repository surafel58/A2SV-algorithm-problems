class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        ///Brute force approach!!
        
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




///Efficient Approach
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        //max element
        int max = 0;
        for(int i=0; i < trips.length; i++)
        {
            if(trips[i][2] > max)
                max = trips[i][2];
        }
        
        //I used line sweep method - prefixSum
        int[] positions = new int[max + 1];

        for(int i=0; i < trips.length; i++)
        {
            int start = trips[i][1];
            int end = trips[i][2];

            positions[start] += trips[i][0];

            if(end < positions.length)
                positions[end] -= trips[i][0];
        }

        for(int i=1; i < positions.length; i++)
            positions[i] += positions[i-1];

        for(int i=0; i<positions.length; i++)
        {
            //if number of passengers on that position is > capacity then return false
            if(positions[i] > capacity)
                return false;
        }
        return true;
    }
}
