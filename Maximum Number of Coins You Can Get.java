class Solution {
    public int maxCoins(int[] piles) {
        
        //sort element
        Arrays.sort(piles);
        
        //limit - how many coins to pick, max - max coin obtained
        int limit = piles.length / 3, max =0;
        
        //iterate through the array starting from the last inner element and keep choosing inner element and add it to max while jumping one element at a time 
        for(int i=piles.length-2, counter = 0; counter < limit; i-=2, counter++)
            max+=piles[i];
        
        //return the max coin 
        return max;
    }
}