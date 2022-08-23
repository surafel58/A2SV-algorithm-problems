class Solution {
    public int totalFruit(int[] fruits) {
        //two pointers - sliding window technique, max_fruits - maximum amount of fruits
        int windowStart = 0, windowEnd = 0, max_fruits = Integer.MIN_VALUE;
        
        //fruit baskets
        Stack<Integer> b1 = new Stack<>();
        Stack<Integer> b2 = new Stack<>();
        
        //iterate through the array with the two pointers and add elements in the baskets
        while(windowEnd < fruits.length)
        {
            //if one of the basket is empty or is if the current element is the same type of fruit found in the basket, add it to its corresponding basket 
            if( (b1.empty() || b2.empty()) || (b1.peek() == fruits[windowEnd] || b2.peek() == fruits[windowEnd]) )
            {
                if(b1.empty() || b1.peek() == fruits[windowEnd])
                        b1.push(fruits[windowEnd]);
                
                else if(b2.empty() || b2.peek() == fruits[windowEnd])
                    b2.push(fruits[windowEnd]);
                windowEnd++;
            }
            
            //else, calculate the max amount of fruits so far and move the window, delete 
            else
            {
                max_fruits = Math.max(max_fruits, windowEnd - windowStart);
                if(b1.peek() == fruits[windowStart])
                    b1.pop();
                else if(b2.peek() == fruits[windowStart])
                    b2.pop();
                windowStart++;
            }
        }
        
        //calculate the final max amount of fruits  
        max_fruits = Math.max(max_fruits, windowEnd - windowStart);
        
        //return the maximum amount of fruits
        return max_fruits;
    }
}