package algorithm.level2twoWayRecursion;

public class LastPositionofTarget {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int lastPosition(int[] nums, int target) {
        return lastPosition(nums, target, 0, nums.length - 1);
    }

    private int lastPosition(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middle = start + (end - start) / 2;
        if (nums[middle] > target) {
            return lastPosition(nums, target, start, middle - 1);
        }
        if (nums[middle] < target) {
            return lastPosition(nums, target, middle + 1, end);
        }
        int temp = lastPosition(nums, target, middle + 1, end);
        if (temp != -1) {
            return temp;
        }
        return middle;
    }
}
