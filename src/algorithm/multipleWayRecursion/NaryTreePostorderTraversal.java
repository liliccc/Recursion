package algorithm.multipleWayRecursion;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal {
    /**
     * @param root: the root of the tree
     * @return: post order of the tree
     */
    public List<Integer> postorder(UndirectedGraphNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(UndirectedGraphNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        for (UndirectedGraphNode neighbour: node.neighbors) {
            dfs(neighbour, result);
        }
        result.add(node.label);
    }
}

 class UndirectedGraphNode {
     int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) {
         label = x;
         neighbors = new ArrayList<UndirectedGraphNode>();
     }
}
