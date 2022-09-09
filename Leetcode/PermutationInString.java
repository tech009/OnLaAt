class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s2.length()<s1.length()) return false;
        int [] a1=new int[26];
        int [] a2=new int[26];
        for(int i=0;i<s1.length();i++) ++a1[s1.charAt(i)-'a'];
        int l=0,r=s1.length()-1;
        for(int i=0;i<=r;i++) ++a2[s2.charAt(i)-'a'];
        while(r<s2.length()){
            if(check(a1,a2)) return true;
            else{
                --a2[s2.charAt(l)-'a']; 
                r++; l++;
                if(r<s2.length()) ++a2[s2.charAt(r)-'a']; 
            }
        }
        return false;
    }
    public static boolean check(int [] a1,int [] a2){
        for(int i=0;i<a1.length;i++) if(a1[i]!=a2[i]) return false; 
        return true;
    }
}