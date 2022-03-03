package algorithm.twoWayRecursion;

import algorithm.twoWayRecursion.utils.TreeNode;

public class MaximumBinaryTree {
    /**
     * @param nums: an array
     * @return: the maximum tree
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int position = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[position]) {
                position = i;
            }
        }
        TreeNode root = new TreeNode(nums[position]);
        root.left = buildTree(nums, start, position - 1);
        root.right = buildTree(nums, position + 1, end);
        return root;
    }
}
