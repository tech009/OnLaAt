class Solution {
    
    public int[] twoSum(int[] numbers, int target) {
        int first = 0, sec = numbers.length-1;
        while(first!=sec){
            if((numbers[first]+numbers[sec])==target)
                break;
            else if((numbers[first]+numbers[sec])>target)
                sec--;
            else
                first++;
        }
        int res[] = new int[2];
        res[0] = first+1;
        res[1] = sec+1;
        
        return res;
    }
}