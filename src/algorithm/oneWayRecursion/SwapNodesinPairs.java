package algorithm.oneWayRecursion;

import algorithm.oneWayRecursion.utils.ListNode;

public class SwapNodesinPairs {
    /**
     * @param head: a ListNode
     * @return: a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        ListNode suffix = swapPairs(second.next);
        second.next = first;
        first.next = suffix;
        return second;
    }
}

