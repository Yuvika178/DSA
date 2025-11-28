class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false; // Negative numbers aren't palindromes

        int original = x;
        int rev = 0;

        while (x > 0) {
            int digit = x % 10;
            rev = rev * 10 + digit;
            x /= 10;
        }

        return rev == original;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(121)); // Output: true
        System.out.println(solution.isPalindrome(-121)); // Output: false
        System.out.println(solution.isPalindrome(10)); // Output: false
    }
}
