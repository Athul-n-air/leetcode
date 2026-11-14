class Solution {

    int f(int i, int  j,List<List<Integer>> triangle, int[][] dp, int n){
        if(i== n-1) return triangle.get(i).get(j);
        if(dp[i][j]!= -1) return dp[i][j];
        int down = triangle.get(i).get(j) + f(i+1,j,triangle,dp,n);
        int diagnal = triangle.get(i).get(j) + f(i+1,j+1,triangle,dp,n);
        return dp[i][j] = Math.min(down,diagnal);
    }
    // upar wala memorization h niche tabulation 
    public int minimumTotal(List<List<Integer>> triangle) {
       int n = triangle.size();
        // dp array initialized with the values of the last row
        int[] dp = new int[n];
        for (int j = 0; j < n; j++) {
            dp[j] = triangle.get(n - 1).get(j);
        }

        // Iterate from the second-last row up to the top
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }
}