class Solution {
    public int concatenatedBinary(int n) {
            int module=(int)(1e9+7);
    
    long e=0;
    int shift=0;
    for(int i=1;i<=n;i++)
    {
        if((i-1 & i)==0)
        {
            shift++;
        }            
        e= ((e<<shift)+i)%module;
    }        
    return (int)e;           
    }
}