package algorithm.level3multipleWayRecursion;

import java.util.HashSet;
import java.util.Set;

public class BeautifulArrangement {
    /**
     * @param N: The number of integers
     * @return: The number of beautiful arrangements you can construct
     */
    public int countArrangement(int N) {
        return helper(N, new HashSet<>());
    }

    private int helper(int n, Set<Integer> visited) {
        if (visited.size() == n) {
            return 1;
        }
        int counter = 0;
        for (int num = 1; num <= n; num++) {
            if(visited.contains(num)) {
                continue;
            }
            if (num % (visited.size() + 1) != 0 && (visited.size() + 1) % num != 0) {
                continue;
            }
            visited.add(num);
            counter += helper(n, visited);
            visited.remove(num);
        }
        return counter;
    }
}
