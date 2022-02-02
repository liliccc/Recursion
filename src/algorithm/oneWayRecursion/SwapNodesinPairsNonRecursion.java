package algorithm.oneWayRecursion;

import algorithm.oneWayRecursion.utils.ListNode;

public class SwapNodesinPairsNonRecursion {
    /**
     * @param head: a ListNode
     * @return: a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (true) {
            if (head.next == null || head.next.next == null) {
                return dummy.next;
            }
            ListNode first = head.next;
            ListNode second = head.next.next;
            head.next = second;
            first.next = head.next.next;
            second.next = first;
            // move to the next node
            head = first;
        }
    }
}
