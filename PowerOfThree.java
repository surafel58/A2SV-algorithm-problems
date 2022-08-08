class Solution {
    public boolean isPowerOfThree(int n) {
	 	// //use log3 n = x, if 3^x is n then return true
	 	// //if n is zero return false
	 	// if(n==0)
	 	// return false;
	 	// //calculate log n to base 3 
	 	// double x = Math.round(Math.log(n)/Math.log(3));
	 	// //if n log equals to 3 the power of x return true
	 	// if(n == Math.pow(3, x))
	 	// 	return true;
	 	// //otherwise return false
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
        
        //else keep dividing n by 3 - recursively call itself with n/3 input
        else 
            return checkNumber(n/3);
    }
}
