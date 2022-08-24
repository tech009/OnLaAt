class Solution {
    public void reverseString(char[] s) {
        int len = s.length, n = s.length;
        len/=2;
        
        for(int i=0; i<len; i++){
            char tmp = s[i];
            s[i] = s[(n-1) - i];
            s[(n-1) - i] = tmp;
        }
            
    }
}