import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = -1; // default if no greater element exists
            boolean found = false;

            for (int j = 0; j < m; j++) {
                if (nums2[j] == nums1[i]) {
                    found = true; // start looking for next greater element
                }
                if (found && nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    break; // stop at the first greater element
                }
            }
        }

        return result;
    }
}

    
