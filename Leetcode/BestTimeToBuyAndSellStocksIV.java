class Solution {
    public int max(int a, int b){
        return (a>b)?a:b;
    }
    
    public int maxProfit(int k, int[] prices) {
        if(k==0)
            return 0;
        else if(prices.length<=1)
            return 0;
        
        int arr[][] = new int[prices.length][2*k];
        for(int i=0; i<(2*k); i+=2)
            arr[0][i] = Integer.MIN_VALUE;
        
        for(int i=0; i<prices.length; i++){
            for(int j=0; j<(2*k); j++){
                if(i==0){
                    if((j%2)==0)
                        arr[i][j] = max(arr[i][j],(-1)*prices[i]);
                    else
                        arr[i][j] = 0;
                    continue;
                }
                
                if((j%2)==0){
                    if(j==0)
                        arr[i][j] = max(arr[i-1][j], (-1)*prices[i]);
                    else
                        arr[i][j] = max(arr[i-1][j], arr[i][j-1]-prices[i]);
                }
                else
                    arr[i][j] = max(arr[i-1][j], arr[i][j-1]+prices[i]);
            }
        }
        
        return arr[prices.length-1][(2*k)-1];
    }
}