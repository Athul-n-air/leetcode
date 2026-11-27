class Solution {
    public int solve(int i,int j1,int j2, int r,int c,int[][] grid,int[][][] dp){
        if(j1<0||j1>c-1 ||j2<0||j2>c-1) return (int) -1e8;
        if(i==r-1){
            int value = grid[i][j1];
            if(j1!=j2){
                value+= grid[i][j2];
            }
            return value;
        }
        if(dp[i][j1][j2]!=-1)return dp[i][j1][j2];
        int maxi = (int)-1e8;
        for(int a =-1 ; a<=1;a++){
            for(int b = -1;b<=+1;b++){
                int value = 0;
                if(j1!= j2){
                    value =  grid[i][j1]+grid[i][j2];
                }else{
                    value = grid[i][j1];
                }
                value+= solve(i+1,j1+a,j2+b,r,c,grid,dp);
                maxi = Math.max(maxi,value);
            }
        }
        return dp[i][j1][j2]= maxi ;

    }
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];
        for(int[][] memo : dp){
            for(int[] row: memo){
                Arrays.fill(row,-1);
            }
        }
        return solve(0,0,m-1,n,m,grid,dp);
    }
}