public class ReverseLinkedList {

    /*
    @author: Linh Tran
    @version: Jun 18th, 2021

    Runtime and usage info of the solution:
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
    Memory Usage: 38.9 MB, less than 33.47% of Java online submissions for Reverse Linked List.
    */
 // Definition for singly-linked list
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) { return null; }
        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            ListNode tempNext = temp.next; // record next node before changing the arrow
            temp.next = prev; // reverse the arrow backwards
            prev = temp; // prepare prev to be the temp node, so that standing from next node can point back to it
            temp = tempNext; // go to next node
        }
        return prev;
    }
}
