class Solution {
    public int dfs(int i, int j, int[][] grid){
        int limitI = grid.length;
        int limitJ = grid[0].length;

        if((i>-1)&&(i<limitI)&&(j>-1)&&(j<limitJ))
            if(grid[i][j]==1){
                grid[i][j] = 2;
                return 1+dfs(i, j-1, grid)+dfs(i, j+1, grid)+dfs(i-1, j, grid)+dfs(i+1, j, grid);
            }
        return 0;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        for(int i=0; i<grid.length; i++)
            for(int j=0; j<grid[0].length; j++)
                if(grid[i][j]==1){
                    int sum = dfs(i, j, grid);
                    if(sum>area)
                        area = sum;
                }
        return area;
    }
}
