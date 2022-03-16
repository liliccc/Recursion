package algorithm.level2twoWayRecursion;

import algorithm.level2twoWayRecursion.utils.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    /**
     * @param inorder:   A list of integers that inorder traversal of a tree
     * @param postorder: A list of integers that postorder traversal of a tree
     * @return: Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        if (postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int position = findPosition(inorder, postorder[postEnd]);
        int leftLen = position - inStart;
        int rightLen = inEnd - position;
        root.left = buildTree(inorder, inStart, position - 1, postorder, postStart, postStart + leftLen - 1);
        root.right = buildTree(inorder, position + 1, inEnd, postorder, postEnd - rightLen, postEnd - 1);
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
