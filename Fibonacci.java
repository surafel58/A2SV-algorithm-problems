class Solution {
    //i used Dynamic programming 
    //a hasmap to memoize the solutions for some n
   HashMap<Integer, Integer> memo = new HashMap<>();
    //to store the value of f(n)
    int k;
    public int fib(int n) {
        //if the solution is found or already solved in the memo then return that solution
        if(memo.containsKey(n))
            return memo.get(n);
        //base case n==0 or n==1
        //if n==0 then k=0
        if(n==0)
            k = 0;
        //if n==1 then solution=1
        else if(n==1)
            k = 1;
        //else recursively solve f(n-1) and f(n-2)
        else
            k = fib(n-1) + fib(n-2);
        //put the solution in the memo 
        memo.put(n,k);
        //return the solution
        return k;
            
    }
}