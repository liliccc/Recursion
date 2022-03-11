package algorithm.multipleWayRecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    /**
     * @param nums: A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        // error before: need to sort
        Arrays.sort(nums);
        dfs(nums, permutations, new ArrayList<>(), new boolean[nums.length]);
        return permutations;
    }

    private void dfs(int[] nums, List<List<Integer>> permutations, List<Integer> permutation, boolean[] visited) {
        if (permutation.size() == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            // first 1' then 1''
            if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, permutations, permutation, visited);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }
    }
}
