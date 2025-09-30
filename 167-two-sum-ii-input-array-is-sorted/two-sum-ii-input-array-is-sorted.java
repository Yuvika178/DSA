class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int sum = numbers[start] + numbers[end];

            if (sum == target) {
                // Return 1-based indices
                return new int[] {start + 1, end + 1};
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }

        // Return an empty array if no solution is found
        return new int[] {};
    }
}
