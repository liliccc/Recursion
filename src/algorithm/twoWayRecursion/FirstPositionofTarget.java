package algorithm.twoWayRecursion;

public class FirstPositionofTarget {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middle = start + (end - start) / 2;
        if (nums[middle] > target) {
            return binarySearch(nums, target, start, middle - 1);
        }
        if (nums[middle] < target) {
            return binarySearch(nums, target, middle + 1, end);
        }
        int temp = binarySearch(nums, target, start, middle - 1);
        if (temp != -1) {
            return temp;
        }
        return middle;
    }
}
