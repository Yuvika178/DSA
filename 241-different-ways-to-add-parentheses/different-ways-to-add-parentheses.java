import java.util.*;

class Solution {

    // Memo (cache) to store already computed results
    private Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {

        // If we already solved this expression before, return cached answer
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> result = new ArrayList<>();

        // Loop through the expression to find operators
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // If current character is an operator, split
            if (c == '+' || c == '-' || c == '*') {

                // Solve left part
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));

                // Solve right part
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                // Combine all results from left × right
                for (int a : left) {
                    for (int b : right) {
                        if (c == '+') result.add(a + b);
                        else if (c == '-') result.add(a - b);
                        else result.add(a * b);
                    }
                }
            }
        }

        // BASE CASE:
        // If result is empty, expression contains only a number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        // Save to memo for future reuse
        memo.put(expression, result);
        return result;
    }
}
