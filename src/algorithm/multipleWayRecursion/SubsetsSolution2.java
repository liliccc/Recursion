package algorithm.multipleWayRecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsSolution2 {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, combinations, new ArrayList<>());
        return combinations;
    }

    private void helper(int[] nums, int start, List<List<Integer>> combinations, List<Integer> combination) {
        combinations.add(new ArrayList<>(combination));
        for (int i = start; i < nums.length; i++) {
            combination.add(nums[i]);
            helper(nums, i + 1, combinations, combination);
            combination.remove(combination.size() - 1);
        }
    }
}
