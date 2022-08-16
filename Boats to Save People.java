class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        //boats = 0, two pointers
        int boats=0, index1=0, index2=people.length-1;
        
        //sort the weight
        Arrays.sort(people);
        
        //iterate through the array 
        while(index1 < index2)
        {
            //move the two pointers
            if(people[index1] + people[index2] <= limit)
            {
                index1++;
                index2--;
            }
            
            //move only the second pointer
            else
                index2--;
            
            //increment amount of boats
            boats++;
        }
        
        //if there are remaining people, increment boats amount
        if(index1 == index2)
            boats++;
        
        //return amount of boats
        return boats;
    }
}