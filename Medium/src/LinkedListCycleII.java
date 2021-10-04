public class LinkedListCycleII {

    /*
     * @author: Linh Tran
     * 
     * @version: Oct 3rd, 2021
     * 
     * Runtime and usage info of the solution: Runtime: 0 ms, faster than 100.00% of
     * Java online submissions for Linked List Cycle II. Memory Usage: 38.8 MB, less
     * than 86.28% of Java online submissions for Linked List Cycle II.
     */

    /**
     * Definition for singly-linked list. class ListNode { int val; ListNode next;
     * ListNode(int x) { val = x; next = null; } }
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        // find the intersection
        ListNode intersection = findIntersection(head);
        // if no cycle
        if (intersection == null) {
            return null;
        }

        // find the start of cycle
        ListNode pointer1 = intersection, pointer2 = head;
        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;

        }

        return pointer1;
    }

    private ListNode findIntersection(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return fast;
            }
        }

        return null;
    }
}
