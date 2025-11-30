import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<String>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> currentPartition, List<List<String>> result) {
        if (start == s.length()) {
            // reached end — add a copy of current partition to result
            result.add(new ArrayList<>(currentPartition));
            return;
        }
        // try every possible end index for substring starting at ‘start’
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                // if s[start..end] is palindrome — choose it
                currentPartition.add(s.substring(start, end + 1));
                // recurse for rest
                backtrack(s, end + 1, currentPartition, result);
                // backtrack — remove last added substring
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        // check if substring s[left..right] is palindrome
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // For testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s1 = "aab";
        String s2 = "a";
        System.out.println(sol.partition(s1));  // prints [[a, a, b], [aa, b]]
        System.out.println(sol.partition(s2));  // prints [[a]]
    }
}
