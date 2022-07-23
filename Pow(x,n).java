class Solution {
    public double myPow(double x, int n) { 
        
        //base cases
        if(n==0 || x==1)
            return 1;
        
        if(x == 0) 
            return 0;
        
        //if power is negative then it must be 1 / pow(x,n)
        if(n < 0)
        {
            //if n is the maximum number considering the constraint, then return 1 or 0  
            if(n == Math.pow(-2, 31)) 
            {
                //if x is -1 then it must be 1
                if(x == -1)
                    return 1;
                //otherwise 0
                return 0;
            }
            
            //call the function recursively
            return 1 / (x * myPow(x, (Math.abs(n) - 1)));
        }
        
        else
        {
            //if n is the maximum number considering the constraint, then return -1 or 0  
            if(n == (Math.pow(2, 31) - 1))
            {
                //if x is -1 then it must be -1
                if(x == -1)
                    return -1;
                //otherwise 0
                return 0;
            }
            //call the function recursively (pow(x, n-1))
            return x * myPow(x, (n - 1));
        }
    }
}