class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length > 1){
            int zero = 0, one = 0;
            for(int num: nums)
                if (num!=0)
                    one++;
                else
                    zero++;
            
            if((zero!=(nums.length))&&(one!=(nums.length))){
                int arr1[] = new int[one];
                
                int count=0;
                for(int num: nums)
                    if(num!=0)
                        arr1[count++]=num;
                
                for(int i=0; i< one; i++)
                    nums[i] = arr1[i];
                
                for(int i=one; i<nums.length; i++)
                    nums[i] = 0;
            }
        }
    }
}