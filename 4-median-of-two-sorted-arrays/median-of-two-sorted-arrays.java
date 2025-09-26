
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
    int[] merged = new int[m + n];
    int i = 0, j = 0, k = 0;

    // Merge the two arrays
    while (i < m && j < n) {
        if (nums1[i] < nums2[j]) {
            merged[k++] = nums1[i++];
        } else {
            merged[k++] = nums2[j++];
        }
    }

    // Copy remaining elements
    while (i < m) merged[k++] = nums1[i++];
    while (j < n) merged[k++] = nums2[j++];

    // Find the median
    int totalLength = m + n;
    if (totalLength % 2 == 1) {
        return merged[totalLength / 2];
    } else {
        return (merged[totalLength / 2 - 1] + merged[totalLength / 2]) / 2.0;
    }
}
}