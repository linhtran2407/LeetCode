public class LinkedListCycle {

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
