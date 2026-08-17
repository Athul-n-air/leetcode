class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        // prefix[i] = sum of stoneValue[0..i-1]
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        // dp[i][j] = best score obtainable from stoneValue[i..j]
        int[][] dp = new int[n][n];   // dp[i][i] = 0 by default

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                int best = 0;

                for (int m = i; m < j; m++) {          // cut between m and m+1
                    int left  = prefix[m + 1] - prefix[i];
                    int right = prefix[j + 1] - prefix[m + 1];

                    if (left < right) {
                        best = Math.max(best, left + dp[i][m]);
                    } else if (right < left) {
                        best = Math.max(best, right + dp[m + 1][j]);
                    } else {
                        best = Math.max(best,
                                left + Math.max(dp[i][m], dp[m + 1][j]));
                    }
                }

                dp[i][j] = best;
            }
        }

        return dp[0][n - 1];
    }
}