class Solution {
    public int minDays(int[][] grid) {
        if(countdays(grid)!=1){
            return 0;
        }
         int n = grid.length;
        int m  = grid[0].length;
        for(int i =0;i<n;i++){
            for(int j = 0 ;j<m;j++){
                if(grid[i][j]==1){
                    grid[i][j]=0;
                    if(countdays(grid)!=1){
                        return 1;
                    }
                    grid[i][j]=1;
                }
            }}
        
        return 2;
        
    }
    public int countdays(int[][] grid){
        int n = grid.length;
        int m  = grid[0].length;
        int count =0;
        int[][] vis = new int[n][m];
        for(int i =0;i<n;i++){
            for(int j = 0 ;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]!=1){
                    dfs(i,j,grid,vis);
                    count++;
                }
            }
        }
        return count;
    }
    void dfs(int r,int j , int[][] grid,int[][] vis){
        vis[r][j]=1;
        int[] dr = {0,-1,0,1};
        int[] dc = {1,0,-1,0};
        for(int i  = 0;i<4;i++){
            int nr= r + dr[i];
            int nc = j + dc[i];
            if(nr<grid.length && nr>=0 && nc< grid[0].length && nc>=0 && grid[nr][nc]==1 && vis[nr][nc]!=1){
                dfs(nr,nc,grid,vis);
            }
        }
    }
}