import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        int n = digits.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;

                    int a = digits[i];
                    int b = digits[j];
                    int c = digits[k];

                    if (a == 0) continue;      // no leading zero
                    if ((c & 1) == 1) continue; // must be even

                    int num = a * 100 + b * 10 + c;
                    set.add(num);
                }
            }
        }

        if (set.isEmpty()) return new int[0];

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) ans[i] = list.get(i);
        return ans;
    }
}
