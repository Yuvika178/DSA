import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        char[] arr = s.toCharArray();
        dfs(arr, 0, result);
        return result;
    }

    private void dfs(char[] arr, int index, List<String> result) {
        if (index == arr.length) {
            result.add(new String(arr));
            return;
        }

        char c = arr[index];
        if (Character.isLetter(c)) {
            // Lower-case branch
            arr[index] = Character.toLowerCase(c);
            dfs(arr, index + 1, result);

            // Upper-case branch
            arr[index] = Character.toUpperCase(c);
            dfs(arr, index + 1, result);
        } else {
            // If it's a digit (or non-letter), keep as is
            dfs(arr, index + 1, result);
        }
    }
}
