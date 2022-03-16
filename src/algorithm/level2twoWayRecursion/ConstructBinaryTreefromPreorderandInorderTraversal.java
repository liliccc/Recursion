package algorithm.level2twoWayRecursion;

import algorithm.level2twoWayRecursion.utils.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    /**
     * @param preorder: A list of integers that preorder traversal of a tree
     * @param inorder: A list of integers that inorder traversal of a tree
     * @return: Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1,inorder ,0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int position = findPosition(inorder, preorder[preStart]);
        int leftLen = position - inStart;
        int rightLen = inEnd - position;
        root.left = buildTree(preorder, preStart + 1, preStart + leftLen, inorder, inStart, position - 1);
        root.right = buildTree(preorder, preEnd - rightLen + 1, preEnd, inorder, position + 1, inEnd);
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
