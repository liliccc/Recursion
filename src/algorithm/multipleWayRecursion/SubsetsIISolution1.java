package algorithm.multipleWayRecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsIISolution1 {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, combinations, new ArrayList<>(), false);
        return combinations;
    }

    private void helper(int[] nums, int start, List<List<Integer>> combinations, List<Integer> combination, boolean notchoose) {
        if (start == nums.length) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        helper(nums, start + 1, combinations, combination, true);
        if (notchoose && nums[start] == nums[start - 1]) {
            return;
        }
        combination.add(nums[start]);
        helper(nums, start + 1, combinations, combination, false);
        combination.remove(combination.size() - 1);
    }
}
