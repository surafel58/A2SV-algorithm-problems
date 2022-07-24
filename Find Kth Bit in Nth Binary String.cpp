class Solution {
public:
    char findKthBit(int n, int k) {
        string Sn = findSn(n);
        return Sn[k-1];
    }
    
    string findSn(int n)
    {
        if(n == 1)
            return "0";
        
        else
        {
            string s = findSn(n - 1);
            string inverted = invert(s);
            reverse(inverted.begin(), inverted.end());
            return s + "1" + inverted;
        }
    }
    
    string invert(string s)
    {
        for(int i = 0, n = s.length(); i < n; i++)
            s[i] = (s[i] == '0') ? '1' : '0';
        
        return s;
    }
    
};