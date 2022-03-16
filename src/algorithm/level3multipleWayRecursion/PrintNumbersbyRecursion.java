package algorithm.level3multipleWayRecursion;

import java.util.ArrayList;
import java.util.List;

public class PrintNumbersbyRecursion {
    /**
     * @param n: An integer
     * @return: An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        List<Integer> results = new ArrayList<>();
        dfs(n, results, 0);
        return results;
    }

    private void dfs(int n, List<Integer> results, int ans) {
        if (n == 0) {
            if (ans > 0) {
                results.add(ans);
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            dfs(n - 1, results,ans * 10 + i);
        }
    }
}
