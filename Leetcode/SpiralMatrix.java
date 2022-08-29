class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        int count = 0, flag=1;
        int imin=0, jmin=0, imax=row-1, jmax=col-1;
        
        List<Integer> res = new ArrayList<>();
        
        while(count!=(row*col)){
            if(flag==1){
                for(int j=jmin; j<=jmax; j++){
                    res.add(matrix[imin][j]);
                    count++;
                    flag=2;
                }
                imin++;
            }
            else if(flag==2){
                for(int i=imin; i<=imax; i++){
                    res.add(matrix[i][jmax]);
                    count++;
                    flag=3;
                }
                jmax--;
            }
            else if(flag==3){
                for(int j=jmax; j>=jmin; j--){
                    res.add(matrix[imax][j]);
                    count++;
                    flag=4;
                }
                imax--;
            }
            else{
                for(int i=imax; i>=imin; i--){
                    res.add(matrix[i][jmin]);
                    count++;
                    flag=1;
                }
                jmin++;
            }
        }
        return res;
    }
}