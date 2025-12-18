class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        int half = k / 2;

        // Step 1: Original profit
        long baseProfit = 0;
        for (int i = 0; i < n; i++) {
            baseProfit += (long) strategy[i] * prices[i];
        }

        long maxProfit = baseProfit;

        // Step 2: Initial window adjustment
        long removed = 0, added = 0;

        // Removed: original contribution of whole window
        for (int i = 0; i < k; i++) {
            removed += (long) strategy[i] * prices[i];
        }

        // Added: last k/2 elements become sell (=1)
        for (int i = half; i < k; i++) {
            added += prices[i];
        }

        maxProfit = Math.max(maxProfit, baseProfit - removed + added);

        // Step 3: Slide the window
        for (int start = 1; start + k <= n; start++) {
            int end = start + k - 1;

            // Update removed part
            removed -= (long) strategy[start - 1] * prices[start - 1];
            removed += (long) strategy[end] * prices[end];

            // Update added part
            added -= prices[start + half - 1];
            added += prices[end];

            maxProfit = Math.max(maxProfit, baseProfit - removed + added);
        }
                return maxProfit;
    }
}
