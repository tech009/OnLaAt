class Solution {
    
    public int findMax(int r1, int c1, int r2, int c2, int[][] grid){
        int max = grid[r1][c1];
        for(int i=r1; i<=r2; i++)
            for(int j=c1; j<=c2; j++)
                if(max<grid[i][j])
                    max = grid[i][j];
        return max;
    }
    
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int gen = n-2;
        int res[][] = new int[gen][gen];
        
        for(int i=0; i<(n-2); i++)
            for(int j=0; j<(n-2); j++)
                res[i][j] = findMax(i, j, (i+2), (j+2), grid);
        
        return res;
    }
}