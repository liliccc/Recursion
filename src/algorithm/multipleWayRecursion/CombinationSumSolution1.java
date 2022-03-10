package algorithm.multipleWayRecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumSolution1 {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        int[] nums = reduceDuplicate(candidates);
        helper(nums, 0, combinations, new ArrayList<>(), target);
        return combinations;
    }

    private void helper(int[] candidates, int start, List<List<Integer>> combinations, List<Integer> combination, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            combinations.add(new ArrayList<>(combination));
            // error before
            return;
        }
        if (start == candidates.length) {
            return;
        }
        combination.add(candidates[start]);
        helper(candidates, start, combinations, combination, target - candidates[start]);
        combination.remove(combination.size() - 1);
        helper(candidates, start + 1, combinations, combination, target);
    }

    private int[] reduceDuplicate(int[] candidates) {
        Arrays.sort(candidates);
        int index = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[index] != candidates[i]) {
                candidates[++index] = candidates[i];
            }
        }
        int[] newCandidates = new int[index + 1];
        for (int i = 0; i < index + 1; i++) {
            newCandidates[i] = candidates[i];
        }
        return newCandidates;
    }
}
