package algorithm.twoWayRecursion;

import algorithm.twoWayRecursion.utils.TreeNode;

public class BinaryTreeMaximumPathSum {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
     // divide and conquer
     // possible situations: left + root, right + root, root, left + right + root
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findTheMax(root);
        return max;
    }

    private int findTheMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findTheMax(root.left);
        int right = findTheMax(root.right);
        int currentMax = Math.max(Math.max(root.val + left, root.val + right), root.val);
        max = Math.max(max, Math.max(currentMax, root.val + left + right));
        return currentMax;
    }
}
