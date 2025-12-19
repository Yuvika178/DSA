class Solution {
    public String removeDuplicateLetters(String s) {

        int[] lastIndex = new int[26];
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();

        // Step 1: last index store karo
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        // Step 2: main logic
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (visited[ch - 'a']) continue;

            while (!stack.isEmpty()
                    && ch < stack.peek()
                    && lastIndex[stack.peek() - 'a'] > i) {

                visited[stack.pop() - 'a'] = false;
            }

            stack.push(ch);
            visited[ch - 'a'] = true;
        }

        // Step 3: stack → string
        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);

        return sb.toString();
    }
}
