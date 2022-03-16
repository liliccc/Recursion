package algorithm.level3multipleWayRecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumSolution2 {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        int [] nums = reduceDuplicates(candidates);
        helper(nums , 0, combinations, new ArrayList<>(), target);
        return combinations;
    }

    private void helper(int[] candidates, int start, List<List<Integer>> combinations, List<Integer> combination, int target) {
        if (target == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                combination.add(candidates[i]);
                helper(candidates, i, combinations, combination, target - candidates[i]);
                combination.remove(combination.size() - 1);
            }
        }
    }

    private int[] reduceDuplicates(int[] candidates) {
        Arrays.sort(candidates);
        int index = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] != candidates[index]) {
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
