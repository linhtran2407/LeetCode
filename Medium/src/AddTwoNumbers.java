public class AddTwoNumbers {

    /*
    @author: Linh Tran
    @version: Jun 11th, 2021

    Runtime and usage info of the solution:
    Runtime: 2 ms, faster than 77.74% of Java online submissions for Add Two Numbers.
    Memory Usage: 39.4 MB, less than 45.44% of Java online submissions for Add Two Numbers.
*/

     // Definition for singly-linked list.
     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // TC: O(Math.max(l1.size, l2.size))
        // SC: O(Math.max(l1.size, l2.size))

        // 1. iterate through l1 and l2, calc the sum
        ListNode head = new ListNode(0);
        ListNode h1 = l1, h2 = l2, curr = head;
        int carry = 0;

        while (h1 != null || h2 != null) {
            int val1 = (h1 != null)? h1.val : 0;
            int val2 = (h2 != null)? h2.val : 0;
            int sum = val1 + val2 + carry; // temp sum
            curr.next = new ListNode(sum % 10);
            carry = sum/10;

            // update the node
            if (h1!= null) {h1 = h1.next;}
            if (h2!= null) {h2 = h2.next;}
            curr = curr.next;
        }

        // 2. append the carry if any
        if (carry >0) {curr.next = new ListNode(carry);}

        return head.next;
    }
}
