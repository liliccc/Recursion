package algorithm.multipleWayRecursion;

import algorithm.twoWayRecursion.utils.TreeNode;

public class ConstructBinaryTreefromPreorderandPostorderTraversal {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return buildTree(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (postStart > postEnd) {
            return null;
        }
        if (preorder[preStart] != postorder[postEnd]) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        // prevent preorder[preStart + 1] out of bounds
        if (preStart == preEnd || postStart == postEnd) {
            return root;
        }
        // find the root of left subtree
        int position = findPosition(postorder, preorder[preStart + 1]);
        int leftLen = position - postStart + 1;
        int rightLen = postEnd - position -1;
        root.left = buildTree(preorder, preStart + 1, preStart + leftLen, postorder, postStart, postStart + leftLen -1);
        root.right = buildTree(preorder, preEnd - rightLen + 1, preEnd, postorder, postEnd - rightLen, postEnd - 1);
        return root;
    }

    private int findPosition(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
