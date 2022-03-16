package algorithm.level3multipleWayRecursion;

public class TargetSum {
    /**
     * @param nums: the given array
     * @param s: the given target
     * @return: the number of ways to assign symbols to make sum of integers equal to target S
     */
    private int count = 0;
    public int findTargetSumWays(int[] nums, int s) {
        int count = 0;
        if (nums == null) {
            return 0;
        }
        dfs(nums, 0, s);
        return count;
    }

    private void dfs(int[] nums, int start, int target) {
       if (start == nums.length && target == 0) {
            count++;
            return;
       }
       if (start < nums.length) {
            dfs(nums, start + 1, target - nums[start]);
            dfs(nums, start + 1, target + nums[start]);
       }
    }
}
