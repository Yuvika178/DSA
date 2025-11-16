public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(0, 0, "", n, result);
        return result;
    }

    // This method is *outside* generateParenthesis method, but inside the class
    private void backtrack(int openCount, int closeCount, String path, int n, List<String> result) {
        if (openCount == n && closeCount == n) {
            result.add(path);
            return;
        }
        if (openCount < n) {
            backtrack(openCount + 1, closeCount, path + "(", n, result);
        }
        if (closeCount < openCount) {
            backtrack(openCount, closeCount + 1, path + ")", n, result);
        }
    }
}
