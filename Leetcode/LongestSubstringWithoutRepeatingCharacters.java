class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int start = 0;
        int end = 0;
        int max = 0;
        
        for(char c: s.toCharArray()){
            if(hs.contains(c)){
                if(max<(end-start))
                    max = end - start;
                for(int i=start; i<end; i++){
                    hs.remove(s.charAt(i));
                    start++;
                    if(s.charAt(i) == c)
                        break;
                }
            }
            hs.add(c);
            end++;
        }
        if(max<(end-start))
            max = end - start;
        
        return max;
    }
}