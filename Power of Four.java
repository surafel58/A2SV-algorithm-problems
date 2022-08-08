class Solution {
    public boolean isPowerOfFour(int n) {
        //use log4 n = x, if 4^x is n then return true
        //if n is zero return false
        // if(n==0)
        //     return false;
        //calculate log n to base 4 and roundup
	 	// double x = Math.round(Math.log(n)/Math.log(4));
        //if n equals to 4 the power of x return true
	 	// if(n == Math.pow(4, x))
	 		// return true;
        //otherwise return false
	 	// return false;
        
        //call the recursive method and return its result
        return checkNumber(Double.valueOf(n));
    }
    
    
    public boolean checkNumber(Double n)
    {
        //if n is less than or equal to 0 then it cant be power of four
        if(n<=0)
            return false;
        
        //base case - if n is 1 which means its trvially true
        if(n==1)
            return true;
        
        //if n is not integer - then n cant be power of four
        else if((n%1)!=0)
            return false;
        
        //else keep dividing n by 4 - recursively call itself with n/4 input
        else 
            return checkNumber(n/4);
    }
}
