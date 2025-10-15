class Solution {
    public boolean isPalindrome(String s) {
        // Step 1: Remove all characters that are not letters or numbers, and make lowercase
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Step 2: Use two pointers to check if the string reads the same from both ends
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false; // if mismatch found, not a palindrome
            }
            left++;
            right--;
        }

        return true; // if all characters match, it's a palindrome
    }

    // Optional: main method to test the code
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(sol.isPalindrome("racecar")); // true
        System.out.println(sol.isPalindrome("hello")); // false
    }
}
