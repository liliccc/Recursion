package algorithm.level4nonRecursion;

import algorithm.level4nonRecursion.utils.NodeState;
import algorithm.level4nonRecursion.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<NodeState> stack = new Stack<>();
        stack.push(new NodeState(root, 0));
        List<Integer> values = new ArrayList<>();
        while (!stack.isEmpty()) {
            NodeState now = stack.pop();
            TreeNode node = now.node;
            int count = now.count;
            if (node == null) {
                continue;
            }
            if (count == 0) {
                stack.push(new NodeState(node, 3));
                stack.push(new NodeState(node.right, 0));
                stack.push(new NodeState(node, 2));
                stack.push(new NodeState(node.left, 0));
                stack.push(new NodeState(node, 1));
            }
            if (count == 2) {
                values.add(node.val);
            }
        }
        return values;
    }
}



