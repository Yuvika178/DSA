import java.util.*;

class Solution {
    public int thirdMax(int[] nums) {
        // Use a TreeSet to keep numbers sorted and distinct
        TreeSet<Integer> set = new TreeSet<>();
        
        for (int n : nums) {
            set.add(n);
            // Keep only top 3 elements
            if (set.size() > 3) {
                set.pollFirst(); // removes the smallest
            }
        }
        
        // If less than 3 distinct numbers, return the maximum
        if (set.size() < 3) {
            return set.last();
        }
        
        // Otherwise, return the third maximum (the smallest in the set of top 3)
        return set.first();
    }
}

            
        