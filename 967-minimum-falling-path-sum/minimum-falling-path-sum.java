class Solution {
    int f(int i , int j ,int[][] matrix, int[][] dp){
        if(j<0 ||j>=matrix[0].length)return (int)1e8;
        if(i==0)return matrix[0][j];
        if(dp[i][j]!=-101)return dp[i][j];
        int u = matrix[i][j] + f(i-1,j,matrix,dp);
        int ur = matrix[i][j] + f(i-1,j-1,matrix,dp);
        int ul = matrix[i][j] + f(i-1,j+1,matrix,dp);
        return dp[i][j] = Math.min(u,Math.min(ur,ul));
    }
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int min = (int)1e8;
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row,-101);
        }
        for(int j = 0;j<m;j++){
            min = Math.min(min,f(n-1,j,matrix,dp));
        }
        return min;
    }
}