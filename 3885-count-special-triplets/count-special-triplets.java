class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        long mod = 1_000_000_007;

        // Count of all elements on right side initially
        java.util.HashMap<Integer, Integer> right = new java.util.HashMap<>();
        for (int x : nums) {
            right.put(x, right.getOrDefault(x, 0) + 1);
        }

        java.util.HashMap<Integer, Integer> left = new java.util.HashMap<>();
        long ans = 0;

        for (int j = 0; j < n; j++) {
            int mid = nums[j];

            // Remove this j element from right side
            right.put(mid, right.get(mid) - 1);

            // Condition:
            // nums[i] == 2 * nums[j]
            // nums[k] == 2 * nums[j]

            int target = mid * 2;

            long leftCount = left.getOrDefault(target, 0);
            long rightCount = right.getOrDefault(target, 0);

            ans = (ans + (leftCount * rightCount) % mod) % mod;

            // Now move nums[j] to left map
            left.put(mid, left.getOrDefault(mid, 0) + 1);
        }

        return (int) ans;
    }
}
