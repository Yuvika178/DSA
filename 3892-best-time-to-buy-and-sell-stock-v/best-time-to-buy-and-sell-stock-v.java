class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;

        long[][] dp = new long[k + 1][n];

        for (int t = 1; t <= k; t++) {
            long maxDiffBuy = -prices[0];   // for normal transaction
            long maxDiffSell = prices[0];   // for short selling

            for (int i = 1; i < n; i++) {
                // carry previous profit
                dp[t][i] = dp[t][i - 1];

                // normal transaction
                dp[t][i] = Math.max(dp[t][i], prices[i] + maxDiffBuy);

                // short selling
                dp[t][i] = Math.max(dp[t][i], maxDiffSell - prices[i]);

                // update helper
                maxDiffBuy = Math.max(maxDiffBuy, dp[t - 1][i - 1] - prices[i]);
                maxDiffSell = Math.max(maxDiffSell, dp[t - 1][i - 1] + prices[i]);
            }
        }
        return dp[k][n - 1];
    }
}
