class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        
        //sort the string based on custom comparator 
        Arrays.sort(nums, new StringNumberComparator());
        
        //return the kth largest integer
        return nums[nums.length - k];
    }
}

class StringNumberComparator implements Comparator<String>{
 
    //override compare method
    public int compare(String strNumber1, String strNumber2) {
        int length1 = strNumber1.length(), length2 = strNumber2.length();
        
        //compare their length and if equal, compare them lexicographically(unicode)
        if(length1 > length2){
            return 1;
        }else if(length1 < length2){
            return -1;
        }else{
            return strNumber1.compareTo(strNumber2);
        }
    }   
}