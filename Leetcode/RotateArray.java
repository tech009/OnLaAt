class Solution {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        
        if(k>0){
            int n=nums.length;
            int arr[] = new int[n];
            
            int count=0;
            for(int i=(n-k); i<n; i++){
                arr[count] = nums[i];
                count++;
            }
            
            for(int i=0; i<(n-k); i++){
                arr[count] = nums[i];
                count++;
            }
            
            for(int i=0; i<n; i++)
                nums[i] = arr[i];
        }
    }
}