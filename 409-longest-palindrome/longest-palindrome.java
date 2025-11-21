class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int length = 0;

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                // Found a pair
                length += 2;
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        // If some characters are left, one odd count can be in center
        if (!set.isEmpty()) {
            length += 1;
        }

        return length;
    }
}
