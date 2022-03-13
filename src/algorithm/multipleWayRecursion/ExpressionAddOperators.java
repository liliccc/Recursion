package algorithm.multipleWayRecursion;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    /**
     * @param num: a string contains only digits 0-9
     * @param target: An integer
     * @return: return all possibilities
     */
    public List<String> addOperators(String num, int target) {
        List<String> results = new ArrayList<>();
        dfs(num, target, 0, "", 0, 0, results);
        return results;
    }

    private void dfs(String nums, int target, int start, String str, long previous, long current, List<String> results) {
        if (start == nums.length()) {
            if (current == target) {
                results.add(str);
            }
            return;
        }
        for (int i = start; i < nums.length(); i++) {
            long num = Long.parseLong(nums.substring(start, i + 1));
            if (start == 0) {
                dfs(nums, target, i + 1, "" + num, num, num, results);
            }
            else {
                dfs(nums, target, i + 1, str + "*" + num,
                previous * num, current - previous + num * previous, results);
                dfs(nums, target, i + 1, str + "+" + num, num, current + num, results);
                dfs(nums, target, i + 1, str + "-" + num, -num, current - num, results);
            }
            if (num == 0) {
                break;
            }
        }
    }
}
