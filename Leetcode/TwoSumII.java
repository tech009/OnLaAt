class Solution {
    
    public int search(int[] numbers, int idx, int target){
        if(numbers[idx]==target)
            return idx;
        else if(numbers[numbers.length-1]==target)
            return (numbers.length - 1);
        else{
            int start = idx, end = (numbers.length-1); 
            int mid = (start+end)/2;
            while(start<=end){
                if(numbers[mid]==target)
                    return mid;
                else if(numbers[mid]<target){
                    start = mid+1;
                    mid = (start+end)/2;
                    continue;
                }
                else
                    end = mid - 1;
                mid = (start+end)/2;
            }
            return -1;
        }
    }
    
    public int[] twoSum(int[] numbers, int target) {
        int first = 0, sec = 0;
        for(int i=0; i<(numbers.length-1); i++){
            first = i;
            sec = search(numbers, i+1, target-numbers[i]);
            if(sec!=-1)
                break;
        }
        
        int res[] = new int[2];
        res[0] = first+1;
        res[1] = sec+1;
        
        return res;
    }
}