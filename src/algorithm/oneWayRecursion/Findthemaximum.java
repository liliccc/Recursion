package algorithm.oneWayRecursion;

import java.util.List;

public class Findthemaximum {
    /**
     * @param nums: the list of numbers
     * @return: return the maximum number.
     */
    public int maxNum(List<Integer> nums) {
        return maxNum(nums, 0, nums.size() - 1, Integer.MIN_VALUE);
    }

    private int maxNum(List<Integer> nums, int start, int end, int result) {
        if (start > end) {
            return result;
        }
        result = Math.max(result, nums.get(start));
        return maxNum(nums, start + 1, end, result);
    }
}
