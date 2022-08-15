class Solution {
    public int edgeScore(int[] edges) {
        long arr[] = new long[edges.length];
        
        for(int i=0; i<edges.length; i++){
            arr[edges[i]] += i;
        }
        
        long max = 0; 
        int idx = 0;
        for(int i=0; i<arr.length; i++)
            if(max < arr[i]){
                max = arr[i];
                idx = i;
            }
        
        return idx;
    }
}