package algorithm.nonRecursion;

import algorithm.nonRecursion.utils.NodeState;
import algorithm.nonRecursion.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<NodeState> stack = new Stack<>();
        stack.push(new NodeState(root, 0));
        List<Integer> values = new ArrayList<>();
        while(!stack.empty()) {
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
            if (count == 1) {
                values.add(node.val);
            }
        }
        return values;
    }
}

