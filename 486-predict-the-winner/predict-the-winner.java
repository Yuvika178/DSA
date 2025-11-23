class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][n];
        int score = solve(nums, 0, n - 1, dp);
        return score >= 0;
    }

    private int solve(int[] nums, int left, int right, Integer[][] dp) {
        if (dp[left][right] != null) return dp[left][right];
        if (left == right) return nums[left];

        int pickLeft = nums[left] - solve(nums, left + 1, right, dp);
        int pickRight = nums[right] - solve(nums, left, right - 1, dp);
        return dp[left][right] = Math.max(pickLeft, pickRight);
    }
}
