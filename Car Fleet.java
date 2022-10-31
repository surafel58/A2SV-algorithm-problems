class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        //intuition - https://www.youtube.com/watch?v=Pr6T-3yB9RM
        
        //increasing
        Stack<Double> monoStack = new Stack<>();
        
        HashMap<Integer, Integer> pos_speed_map = new HashMap<>();
        
        for(int i=0; i<position.length; i++)
            pos_speed_map.put(position[i], speed[i]);
        
        Arrays.sort(position);
        
        for(int i=0; i<position.length; i++)
            speed[i] = pos_speed_map.get(position[i]);
        
        
        double time_final = (target - position[position.length-1]) / (double)speed[position.length-1];
        monoStack.push(time_final);
        
        for(int i = position.length-2; i >= 0; i--)
        {
            // time it takes to reach final position (target) = (Sf - Si)/v; 
            time_final = (target - position[i]) / (double)speed[i];
            if(!monoStack.empty() && time_final > monoStack.peek())
                monoStack.push(time_final);
        }
        
        return monoStack.size();
    }
}
