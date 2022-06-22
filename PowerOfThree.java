class Solution {
    public boolean isPowerOfThree(int n) {
        //use log3 n = x, if 3^x is n then return true
        //if n is zero return false
        if(n==0)
            return false;
        //calculate log n to base 3 and roundup
	 	double x = Math.round(Math.log(n)/Math.log(3));
        //if n log equals to 3 the power of x return true
	 	if(n == Math.pow(3, x))
	 		return true;
        //otherwise return false
	 	return false;
    }
}