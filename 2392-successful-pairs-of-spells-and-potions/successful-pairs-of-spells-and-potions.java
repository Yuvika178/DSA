public class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
         Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            int index = lowerBound(potions, (int)Math.ceil((double)success / spell));
            result[i] = m - index;
        }
        return result;
    }

    private static int lowerBound(int[] potions, int target) {
        int low = 0, high = potions.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (potions[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
        