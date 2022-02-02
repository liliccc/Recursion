package algorithm.oneWayRecursion;

public class ClassicalBinarySearch {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int findPosition(int[] nums, int target) {
        return findPosition(nums, 0, nums.length - 1, target);
    }

    private int findPosition(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] > target) {
            // nums[mid] != target, mid - 1 || mid + 1
            return findPosition(nums, start, mid - 1, target);
        }
        if (nums[mid] < target) {
            return findPosition(nums, mid + 1, end, target);
        }
        return mid;
    }
}
