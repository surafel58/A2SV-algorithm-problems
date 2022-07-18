class Solution {
    public int maxArea(int[] height) {
        //two pinters, index1 starts at the beginning and index2 starts at the end
        int index1 = 0, index2 = height.length - 1, maxArea = 0;
        
        //iterate through the array and move the pointers and find the maxArea of the containers that are formed   
        while(index1!=index2)
        {
            //calculate area of the given height 
            int area = (index2 - index1) * min(height[index1], height[index2]);
            
            //if the previous stored area is lesser than the current one, assign it as the maxArea
            if(area > maxArea)
                maxArea = area;
            
            //move the pointer which points to a smaller number, (index1 - move right, index2 - move left)
            if(height[index1] < height[index2])
                index1++;
            else
                index2--;
        }
        
        //return the max area of the given container 
        return maxArea;
    }
    
    //calculate the min of two numbers 
    public int min(int a, int b)
    {
        if(a<b)
            return a;
        else
            return b;
    }
}