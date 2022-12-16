class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder result = new StringBuilder();

        for(int i=0; i < s.length(); i++)
        {
            if ((s.charAt(i) >= '0' && s.charAt(i) <= '9') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' &&   s.charAt(i) <= 'Z')){
            // character is alphanumeric
            result.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        for(int i = 0; i < result.length()/2; i++)
        {
            if(result.charAt(i) != result.charAt(result.length() - i - 1))
                return false;            
        }

        return true;
    }
}
