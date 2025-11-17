import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] candidates, int target, 
                           List<Integer> current, List<List<Integer>> result) {

        // If target is exactly 0 → valid combination
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // If we go out of range OR target becomes negative → stop
        if (index >= candidates.length || target < 0) {
            return;
        }

        // Choice 1: Take the element at index
        current.add(candidates[index]);
        backtrack(index, candidates, target - candidates[index], current, result);
        current.remove(current.size() - 1); // backtrack

        // Choice 2: Skip the element and move to the next
        backtrack(index + 1, candidates, target, current, result);
    }
}
