class Solution {
    public int minimumPairRemoval(int[] nums) {

        // Convert array to a list for easy element removal and merging
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        int operations = 0;

        while (!isNonDecreasing(list)) {
            int minSum = Integer.MAX_VALUE;
            int index = -1;

            // Find the leftmost adjacent pair with the minimum sum
            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    index = i;
                }
            }

            // Merge the selected pair
            int merged = list.get(index) + list.get(index + 1);
            list.set(index, merged);      // Replace first element of pair
            list.remove(index + 1);       // Remove second element

            operations++;
        }

        return operations;
    }

    // Helper method to check if the list is non-decreasing
    private boolean isNonDecreasing(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

} 