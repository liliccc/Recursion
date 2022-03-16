package algorithm.level2twoWayRecursion;

import java.util.ArrayList;
import java.util.List;

public class TowerofHanoi {
    /**
     * @param n: the number of disks
     * @return: the order of moves
     */
    public List<String> towerOfHanoi(int n) {
        List<String> path = new ArrayList<>();
        haonoi(n, 'A', 'C', 'B', path);
        return path;
    }

    private void haonoi(int n, char start, char end, char temp, List<String> path) {
        if (n == 1) {
            path.add(move(start, end));
            return;
        }
        haonoi(n - 1, start, temp, end, path);
        path.add(move(start, end));
        haonoi(n - 1, temp, end, start, path);
    }

    private String move(char from, char to) {
        return "from " + from + " to " + to;
    }
}
