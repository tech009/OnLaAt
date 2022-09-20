class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int max = 0;
        int arr[][] = new int[nums2.length+1][nums1.length+1];
        
        for(int i=0; i<nums2.length; i++){
            for(int j=0; j<nums1.length; j++){
                if(nums2[i]==nums1[j]){
                        arr[i+1][j+1] = arr[i][j]+1;

                    if(max<arr[i+1][j+1])
                        max = arr[i+1][j+1];
                }
            }
        }
        
        return max;
    }
}