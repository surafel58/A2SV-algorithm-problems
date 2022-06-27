class Solution {
    public boolean isPowerOfFour(int n) {
         //use log4 n = x, if 4^x is n then return true
        //if n is zero return false
        if(n==0)
            return false;
        //calculate log n to base 4 and roundup
	 	double x = Math.round(Math.log(n)/Math.log(4));
        //if n equals to 4 the power of x return true
	 	if(n == Math.pow(4, x))
	 		return true;
        //otherwise return false
	 	return false;
    }
}