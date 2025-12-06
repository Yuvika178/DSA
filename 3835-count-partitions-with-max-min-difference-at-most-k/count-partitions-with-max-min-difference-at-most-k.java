import java.util.*;

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        // dp[i] = number of ways to partition first i elements (0..i-1)
        long[] dp = new long[n + 1];
        long[] pref = new long[n + 1];  // prefix sums of dp
        dp[0] = 1;
        pref[0] = 1;

        // We'll maintain window [l..r] (0-indexed on nums) with deques for max and min
        Deque<Integer> dqMin = new ArrayDeque<>();
        Deque<Integer> dqMax = new ArrayDeque<>();

        int l = 0;
        for (int r = 0; r < n; r++) {
            // add nums[r] to window
            while (!dqMin.isEmpty() && nums[dqMin.peekLast()] > nums[r]) {
                dqMin.pollLast();
            }
            dqMin.offerLast(r);

            while (!dqMax.isEmpty() && nums[dqMax.peekLast()] < nums[r]) {
                dqMax.pollLast();
            }
            dqMax.offerLast(r);

            // shrink from left while window invalid
            while (l <= r && nums[dqMax.peekFirst()] - nums[dqMin.peekFirst()] > k) {
                if (dqMin.peekFirst() == l) dqMin.pollFirst();
                if (dqMax.peekFirst() == l) dqMax.pollFirst();
                l++;
            }

            // now subarrays from any start j in [l..r] to r is valid
            // dp[r+1] = sum(dp[j] for j from l..r) = pref[r] - pref[l-1]
            long ways = pref[r];
            if (l > 0) ways = (ways - pref[l - 1] + MOD) % MOD;
            dp[r + 1] = ways;
            pref[r + 1] = (pref[r] + dp[r + 1]) % MOD;
        }

        return (int) dp[n];
    }
}
