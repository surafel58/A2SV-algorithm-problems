class Solution {
    public int minimumBuckets(String street) {
        
        StringBuilder str = new StringBuilder(street);
        int result = 0;
        
        //edge case
        if(street.length() == 1 && street.charAt(0) == 'H')
            return -1;
        
        
        //iterate through the string 
        for(int i=0; i<street.length(); i++)
        {
            //if the current char is H
            if(str.charAt(i) == 'H')
            {
                //if there exist an empty place next to it and if its the first H, increment count and replace the empty space with Bucket
                if((i+1 < street.length() && str.charAt(i+1) == '.') && i == 0)
                {
                    result++;
                    str.replace(i+1, i+2, "B");
                }
                
                //else
                else
                {
                    //if there exist an empty place next to it and if its previous element is not a bucket, increment count and replace the empty space with Bucket
                    if((i+1 < street.length() && str.charAt(i+1) == '.') && (i-1 >= 0 && str.charAt(i-1) != 'B'))
                    {
                        result++;
                        str.replace(i+1, i+2, "B");
                    }
                    
                    //else if its previous element is empty space then increment count and replace the empty space with Bucket
                    else if(i-1 >= 0 && str.charAt(i-1) == '.')
                    {
                        result++;
                        str.replace(i-1, i, "B");
                    }
                    
                    //else check if adjacent houses exist, and return -1 if found
                    else if((i-1 >= 0 && str.charAt(i-1) == 'H') && (i+1 < street.length() && str.charAt(i+1) == 'H') || (i-1 == -1 && str.charAt(i+1) == 'H') || (i+1 == street.length() && str.charAt(i-1) == 'H'))
                        return -1;
                }
            }
        }
        return result;
    }
}
