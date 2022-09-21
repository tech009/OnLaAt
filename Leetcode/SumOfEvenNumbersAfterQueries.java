class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
     
        int res[] = new int[queries.length];
        int sum = 0, count = 0;
        
        for(int i: nums)
            if((i%2)==0)
                sum+=i;
        
        for(int[] i: queries){
            if((nums[i[1]]%2)==0){
                nums[i[1]]+=i[0];
                if((nums[i[1]]%2)==0)
                    sum+=i[0];
                else
                    sum-=(nums[i[1]]-i[0]);
            }
            else{
                nums[i[1]]+=i[0];
                if((nums[i[1]]%2)==0)
                    sum+=nums[i[1]];
            }
            
            res[count++]=sum;
        }
        return res;
    }
}