
   import java.util.*;

class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Count frequency of even numbers
        for (int num : nums) {
            if (num % 2 == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        
        // If no even number found
        if (map.isEmpty()) return -1;
        
        int mostFrequent = -1;
        int maxFrequency = 0;

        // Find the most frequent (and smallest if tie)
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            
            if (freq > maxFrequency || (freq == maxFrequency && num < mostFrequent)) {
                maxFrequency = freq;
                mostFrequent = num;
            }
        }
        
        return mostFrequent;
    }
}
