package algorithm.level3multipleWayRecursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
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
            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, permutations, permutation, visited);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }
    }
}
