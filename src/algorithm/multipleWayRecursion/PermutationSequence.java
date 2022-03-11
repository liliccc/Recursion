package algorithm.multipleWayRecursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    /**
     * @param n: n
     * @param k: the k th permutation
     * @return: return the k-th permutation
     */
    public String getPermutation(int n, int k) {
        List<String> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(String.valueOf(i));
        }
        StringBuilder result = new StringBuilder();
        helper(nums, k, result);
        return String.valueOf(result);
    }

    private void helper(List<String> nums, int k, StringBuilder result) {
        if (nums.size() == 0) {
            return;
        }
        int factorial = 1;
        for (int i = 1; i < nums.size(); i++) {
            factorial *= i;
        }
        int first = (k - 1) / factorial;
        result.append(nums.get(first));
        nums.remove(first);
        helper(nums, (k - 1) % factorial + 1, result);
    }
}
