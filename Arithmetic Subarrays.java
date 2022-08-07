class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        
        //resul list
        ArrayList<Boolean> result = new ArrayList<>();
        
        //make all the values true in the list
        for(int i=0; i<l.length; i++)
            result.add(true);
        
        //arthimetic difference
        int diff = 0;
        
        //iterate through the 'l' array and get the interval L[i] - R[i]
        for(int i=0; i<l.length; i++)
        {
            //new temp array of length the same as the current interval 
            int[] temp = new int[(r[i] - l[i])+1];
            
            //copy all the values from nums array to temp array which are in the interval L[i] - R[i]
            for(int k=l[i], t=0; k<=r[i]; k++,t++)
                temp[t] = nums[k];
            
            //sort the temp array so that to check if the sequence can be arthimetic
            Arrays.sort(temp);
            
            //iterate thorugh the temp array to check if the seuqence is arthimetic
            for(int j=0; j<temp.length-1; j++)
            {
                //if it is the first element calculate the difference 'diff' of the consecutive elements temp[j] and temp[j+1]
                if(j==0)
                    diff = temp[j] - temp[j+1];
                
                //else compare the difference of the current elements with diff 
                else if(temp[j] - temp[j+1] !=diff)
                {
                    //if the difference of the current elements with diff is not the same, set the corresponding value false 
                    result.set(i, false);
                    break;
                }
            }
        }
        
        //return the result 
        return result;
    }
}