
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        findCombinations(candidates, target, 0, current, result);

        return result;
    }

    public void findCombinations(int[] candidates, int target,
                                 int index, List<Integer> current,
                                 List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (index == candidates.length || target < 0) {
            return;
        }

        // Take the current number
        current.add(candidates[index]);

        findCombinations(candidates, target - candidates[index],
                         index, current, result);

        // Do not take the current number
        current.remove(current.size() - 1);

        findCombinations(candidates, target, index + 1,
                         current, result);
    }
}
