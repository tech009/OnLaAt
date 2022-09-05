class Solution {
    public void calc(int num, int k, int n, List<Integer> res){
        
        if(n==0)
            res.add(num);
        else{
            int arr[] = new int[]{0, 1, 2, 3, 4, 5, 6, 7 ,8, 9};
            int ld = num%10;
            
            for(int i: arr){
                int x = ld-i;
                if(x<0)
                    x*=-1;
                if(x==k)
                    calc(((num*10)+i), k, n-1, res);
            }
        }
    }
    public int[] numsSameConsecDiff(int n, int k) {
    
        List<Integer> res = new ArrayList<>();
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        for(int i: arr)
            calc(i, k, n-1, res);
        
        int result[] = new int[res.size()];
        for(int i=0; i<res.size(); i++)
            result[i] = res.get(i);
        
        return result;
    }
}