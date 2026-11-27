class Solution {
    public int f(int c1, int r1,int r2, int n , int[][] grid, int[][][] dp){
        int c2 = c1 + r1 - r2;
        if(c1 >= n ||c2>=n || r1>= n||r2>=n||grid[c1][r1]==-1 || grid[c2][r2]==-1) return (int)-1e8;
        if(r1==n-1 && c1==n-1)return grid[c1][r1];
        if(dp[c1][r1][r2]!=-1)return dp[c1][r1][r2];
        int cherry = grid[c1][r1];
        if(r1!=r2) cherry +=grid[c2][r2];

        int best = Math.max(
            Math.max(f(c1,r1 + 1, r2 + 1,n,grid,dp), f(c1,r1 + 1, r2,n,grid,dp)),
            Math.max(f(c1 + 1, r1, r2 + 1,n,grid,dp), f(c1 + 1, r1, r2,n,grid,dp))
        );

        if (best == (int)-1e8) {
            dp[c1][r1][r2] =(int)-1e8;
        } else {
            dp[c1][r1][r2] = cherry + best;
        }
        return dp[c1][r1][r2];

    }
    
    public int cherryPickup(int[][] grid) {
        int  n = grid.length;
        int[][][] dp = new int[n][n][n];
        for(int [][] memo : dp){
            for(int[] row : memo){
                Arrays.fill(row,-1);
            }
        } 
        int ans =  f(0,0,0,n,grid,dp);
        return Math.max(0,ans);
    }
}