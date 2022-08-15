class Solution {
    public int searchInsert(int[] nums, int target) {
        int start=0, end=nums.length-1, mid=0, res=0;
        
        if((target<nums[start])||(target==nums[start]))
            return start;
        else if((target>nums[end]))
            return end+1;
        else if(target==nums[end])
            return end;
        else{
            while(start<=end){
                mid = start+(end-start)/2;
                if(target==nums[mid])
                    return mid;
                else if(target>nums[mid]){
                    start = mid+1;
                    res=start;
                }
                else{
                    end = mid-1;
                }
            }
            return res;
        }
    }
}