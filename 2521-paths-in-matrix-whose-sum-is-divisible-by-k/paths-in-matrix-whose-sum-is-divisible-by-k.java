class Solution {
    public int numberOfPaths(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        int MOD = 1_000_000_007;

        // dp[i][j][r] = number of ways to reach cell (i,j) 
        // such that sum % k = r
        int[][][] dp = new int[m][n][k];

        dp[0][0][grid[0][0] % k] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                for (int r = 0; r < k; r++) {

                    int currentWays = dp[i][j][r];
                    if (currentWays == 0) continue;

                    int newR;

                    // Move Down
                    if (i + 1 < m) {
                        newR = (r + grid[i+1][j]) % k;
                        dp[i+1][j][newR] = (dp[i+1][j][newR] + currentWays) % MOD;
                    }

                    // Move Right
                    if (j + 1 < n) {
                        newR = (r + grid[i][j+1]) % k;
                        dp[i][j+1][newR] = (dp[i][j+1][newR] + currentWays) % MOD;
                    }
                }
            }
        }

        // Return number of paths whose sum % k == 0
        return dp[m-1][n-1][0];
    }
}
