package algorithm.multipleWayRecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsSolution1 {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    // Solve by using binary tree
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, combinations, new ArrayList<>());
        return combinations;
    }

    private void helper(int[] nums, int start, List<List<Integer>> combinations, ArrayList<Integer> combination) {
        if (start == nums.length) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        combination.add(nums[start]);
        helper(nums, start + 1, combinations, combination);
        combination.remove(combination.size() - 1);
        helper(nums, start + 1, combinations, combination);
    }


}
