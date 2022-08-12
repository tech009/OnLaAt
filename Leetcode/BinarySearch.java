// 704. Binary Search


class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1, mid = 0;
        if(nums[start] == target)
            return start;
        else if(nums[end] == target)
            return end;
        else if((target<nums[start])||(target>nums[end]))
            return -1;
        else
            while(start<end){
                mid = (start+end)/2;
                if(target>=nums[mid]){
                    if(nums[mid] == target)
                        return mid;
                    else if(nums[end] == target)
                        return end;
                    start = mid+1;
                }
                else{
                    if(nums[start] == target)
                        return start;
                    else if(nums[mid] == target)
                        return mid;
                    end = mid-1;
                }
            }
        return -1;
    }
}