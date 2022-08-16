class Solution {
    public int[] sortedSquares(int[] nums) {
        if(nums[0]>=0){
            int res[] = new int[nums.length];
            for(int i=0; i<nums.length; i++)
                res[i] = nums[i]*nums[i];
            return res;
        }
        
        else if(nums[nums.length-1]<=0){
            int res[] = new int[nums.length];
            for(int i=nums.length-1; i>=0; i--)
                res[(nums.length-(i+1))] = nums[i]*nums[i];
            return res;
        }
        
        else{
            int n=nums.length;
            int l=0;
            while(nums[l]<0)
                l++;
            
            int larr[] = new int[l];
            int rarr[] = new int[n-l];
            
            l--;
            
            for(int i=l; i>=0; i--)
                larr[(l-i)] = nums[i]*nums[i];
            
            for(int i=(l+1); i<n; i++)
                rarr[i-(l+1)] = nums[i]*nums[i];
            
            l++;
            
            int res[] = new int[n];
            int count = 0, r=n-l, lc=0, rc=0;
            
            while(count!=n){
                if(lc==l){
                    res[count] = rarr[rc];
                    rc++;
                    count++;
                    continue;
                }
                else if(rc==r){
                    res[count] = larr[lc];
                    lc++;
                    count++;
                    continue;
                }
                else{
                    if(larr[lc]>rarr[rc]){
                        res[count] = rarr[rc];
                        rc++;
                        count++;
                        continue;
                    }
                    res[count] = larr[lc];
                    lc++;
                    count++;
                }
            }
            return res;
        }
    }
}