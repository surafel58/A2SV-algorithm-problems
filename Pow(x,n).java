class Solution {
    //I used Dynamic programming 
    
    //a hasmap to memoize the solutions for some n
    HashMap<Integer, Double> memo = new HashMap<>();
    
    //to store the value of p(x,n)
    double k;
    
    public double myPow(double x, int n) {
        
        //if the solution is found or already solved in the memo then return that solution
        if(memo.containsKey(n))
            return memo.get(n);
        
        //base case
        if(n==1||x==1)
            k = x;
        
        //exceptional cases
        else if(x==0)
            k = 0;
        
        else if(n==0) 
            k = 1;
        
        //else recursively solve myPow(x, Math.abs(n/2)) * myPow(x, Math.abs(n/2)) - even, or solve myPow(x, Math.abs(n/2)) * myPow(x, Math.abs(n - n/2)) - odd
        else
        {
            k = (myPow(x, Math.abs(n/2)));
            
            //if n is negative k = 1/result
            if(n<0)
            {
                if(n%2!=0)
                    k = 1/(k * myPow(x, Math.abs(n - n/2)));
                else
                    k = 1/(k * k);
            }
            
            
            else
            {
                if(n%2!=0)
                    k = (k * myPow(x, n - n/2));
                else
                    k =  (k * k);
            }
        }
        
        //put the solution in the memo 
        memo.put(n,k);
        
        //return the result
        return k;
    }
}


/*
Another Solution 

class Solution {

    //to store the value of p(x,n)
    double k;
    
    public double myPow(double x, int n) {
        
        //base cases
        if(n==1||x==1)
            k = x;
        
        //exceptional cases
        else if(x==0)
            k = 0;
        
        else if(n==0)
            k = 1;
        
        
        //else recursively solve k = myPow(x, Math.abs(n/2)) and result = k * k - even, or solve myPow(x, Math.abs(n/2)) and result = k * k * x - odd
        else
        {
             k = (myPow(x, Math.abs(n/2)));
                    
            //if n is negative k = 1/result
            if(n<0)
            {
                if(n%2!=0)
                    k = 1/(k * k * x);
                else
                    k = 1/(k * k);
            }
            
            
            else
            {
                if(n%2!=0)
                    k = (k * k * x);
                else
                    k = (k * k);
            }
        }
        
        //return the result
        return k;
    }
}
*/
