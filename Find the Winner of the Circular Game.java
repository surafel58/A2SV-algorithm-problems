class Solution {
    public int findTheWinner(int n, int k) {
        
        if(k == 1)
            return n;
        
        if(n==1)
            return 0;
        
        
        
        HashMap<Integer,String> numbers = new HashMap<>();
        for(int i=0; i<n; i++)
            numbers.put(i+1, "undeleted");

        
        int i = 1;
        
        Iterator it = numbers.entrySet().iterator();  


        int limit = 0, x = 0;
        while(limit != n-1)
        {
            if(!it.hasNext())
                it = numbers.entrySet().iterator();      
            
            Map.Entry mapElement = (Map.Entry)it.next();
            x = ((int)mapElement.getKey());
            
            if(numbers.get(x).equals("deleted"))
                continue;
            
            if(i == k && numbers.get(x).equals("undeleted"))
            {
                numbers.put(x, "deleted");
                limit++;
            }
                
            
            else if(i > k)
                i = 1;
            i++;
        }
        

        
        while(it.hasNext())
        {
            Map.Entry mapElement = (Map.Entry)it.next();
            x = ((int)mapElement.getKey());
            if(numbers.get(x).equals("undeleted"))
                break;
        }
        return x;
    }
}