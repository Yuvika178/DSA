
        class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = lowerBound(nums, target);
        // If target not present
        if (left == nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        // Find first index > target, then subtract 1
        int right = lowerBound(nums, target + 1) - 1;
        return new int[]{left, right};
    }

    // Returns the smallest index i such that nums[i] >= target,
    // or nums.length if none.
    private int lowerBound(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, res = nums.length;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= target) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }
}

        
   
