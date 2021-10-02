public class LinkedListCycle {
    /*
     * @author: Linh Tran
     * 
     * @version: Oct 2nd, 2021
     * 
     * Runtime and usage info of the solution: Runtime: 1 ms, faster than 33.78% of
     * Java online submissions for Linked List Cycle. Memory Usage: 40.2 MB, less
     * than 56.93% of Java online submissions for Linked List Cycle.
     */

    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            // 2 pointers
            if (head == null || head.next == null) {
                return false;
            }

            ListNode slow = head, fast = head;
            while (slow != null && fast != null) {
                if (fast.next == slow) {
                    return true;
                }
                slow = slow.next != null ? slow.next : null;
                fast = fast.next == null ? null : fast.next.next != null ? fast.next.next : null;
            }

            return false;
        }
    }
}
