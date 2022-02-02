package algorithm.oneWayRecursion;

import algorithm.oneWayRecursion.utils.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReverseOrderStorage {
    /**
     * @param head: the given linked list
     * @return: the array that store the values in reverse order
     */
    public List<Integer> reverseStore(ListNode head) {
        List<Integer> result = new ArrayList<>();
        store(head, result);
        return result;
    }

    private void store(ListNode head, List<Integer> result) {
        if (head == null) {
            return;
        }
        store(head.next, result);
        result.add(head.val);
    }
}
