class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        
        
        if(tokens.length==0)
            return 0;
        else if(tokens.length==1){
            if(tokens[0]<=power)
                return 1;
            else
                return 0;
        }
        else{
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Comparator.reverseOrder());
            for(int i: tokens)
                queue.add(i);
            
            
            int arr[] = new int[tokens.length];
            int count = 0;
            while(!queue.isEmpty())
                arr[count++] = queue.poll();
                                   
            int start = 0;
            int  end = arr.length;
            end--;
            int max = 0;
            int score = 0;
            
            if(power<arr[end])
                return 0;

            
            while(start<=end){
                if(power>=arr[end]){
                    power-=arr[end--];
                    score++;
                }
                else if(score>=1){
                    power+=arr[start++];
                    score--;
                }
                else
                    end--;
                
                if(max < score)
                    max = score;
            }
            
            if(max < score)
                    return score;
            return max;
        }
    }
}