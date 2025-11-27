import java.util.Arrays;

class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long ans = Long.MIN_VALUE;
        long prefix = 0;
        long[] minPrefix = new long[k];
        Arrays.fill(minPrefix, Long.MAX_VALUE / 2);
        // This ensures we consider subarrays starting from index 0
        minPrefix[k - 1] = 0;

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            // If we pick a previous prefix sum with the same modulo (i % k),
            // the subarray length will be divisible by k
            ans = Math.max(ans, prefix - minPrefix[i % k]);
            // Update the minimum prefix sum for this remainder class
            minPrefix[i % k] = Math.min(minPrefix[i % k], prefix);
        }
        return ans;
    }

    // Example test
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {1, 2};
        int k1 = 1;
        System.out.println(sol.maxSubarraySum(arr1, k1));  // Output: 3

        int[] arr2 = {-1, -2, -3, -4, -5};
        int k2 = 4;
        System.out.println(sol.maxSubarraySum(arr2, k2));  // Output: -10

        int[] arr3 = {-5, 1, 2, -3, 4};
        int k3 = 2;
        System.out.println(sol.maxSubarraySum(arr3, k3));  // Output: 4
    }
}
