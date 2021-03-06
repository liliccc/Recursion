package algorithm.level3multipleWayRecursion;

public class NextPermutation {
    /**
     * @param nums: A list of integers
     * @return: A list of integers
     */
    public int[] nextPermutation(int[] nums) {
        int index = -1;
        for (int i = nums.length - 2; i>=0 ; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return nums;
        }
        int lastBiggest = index + 1;
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                lastBiggest = i;
                break;
            }
        }
        int temp = nums[index];
        nums[index] = nums[lastBiggest];
        nums[lastBiggest] = temp;
        reverse(nums, index + 1, nums.length - 1);
        return nums;
    }

    public void reverse(int[] num, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
    }
}
