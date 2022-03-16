package algorithm.level2twoWayRecursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PossibleBipartition {
    /**
     * @param N:  sum of the set
     * @param dislikes: dislikes peoples
     * @return:  if it is possible to split everyone into two groups in this way
     */
     // solution: graph coloring
    private ArrayList<Integer>[] graph;
    private Map<Integer, Integer> colors; // value: 0 - blue, 1 - red
    public boolean possibleBipartition(int N, int[][] dislikes) {
        // construct the graph
        graph = new ArrayList[N + 1]; // index 0 is not used
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : dislikes) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        colors = new HashMap<>();
        for (int i = 1; i < N + 1; i++) {
            // i does not have color and coloring it and its neighbours is not successful
            if (!colors.containsKey(i) && !dfs(i, 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, int color) {
        if (colors.containsKey(node)) {
            // neighbour has the correct colors
            return colors.get(node) == color;
        }
        colors.put(node, color);
        for (int neighbour: graph[node]) {
            // check if neighbour has the opposite color: color ^ 1
            if (!dfs(neighbour, color ^ 1)) {
                return false;
            }
        }
        return true;
    }
}
