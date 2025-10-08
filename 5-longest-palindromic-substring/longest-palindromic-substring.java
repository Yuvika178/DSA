class Solution {
    public String longestPalindrome(String s) {
        
        if (s == null || s.length() < 1) return "";

        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            // Odd length palindrome
            String odd = expandFromCenter(s, i, i);
            // Even length palindrome
            String even = expandFromCenter(s, i, i + 1);

            // Update longest
            if (odd.length() > longest.length()) {
                longest = odd;
            }
            if (even.length() > longest.length()) {
                longest = even;
            }
        }

        return longest;
    }

    private String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // substring(start, end) excludes the character at index 'end'
        return s.substring(left + 1, right);
    }

}
    