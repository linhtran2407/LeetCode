public class ReverseLinkedListII {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            // TC: O(N)
            // SC: O(1)

            if (left == right){return head;}

            ListNode curr = head; // used for traversal
            int count = 1;
            ListNode prevLeft = null;

            // find left node and store its prev node
            while (count < left){
                prevLeft = curr;
                curr = curr.next;
                count++;
            }

            ListNode leftNode = curr;

            ListNode rightNext = null;
            ListNode prev = prevLeft;

            // reverse until find right node and store rightNext
            while (count <= right){
                // reverse
                rightNext = curr.next;
                curr.next = prev;
                prev = curr;
                curr = rightNext;

                // update
                count++;
            }

            ListNode rightNode = prev;

            // connect right node with prevLeft and left node with rightNext
            if (prevLeft != null){
                prevLeft.next = rightNode;
            } else {
                head = rightNode;
            }

            leftNode.next = rightNext;

            return head;
        }
    }
}
