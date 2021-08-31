public class ReverseLinkedListII {


     // Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    class Solution_recursion {

        private boolean stop;
        private ListNode start;

        public ListNode reverseBetween(ListNode head, int left, int right) {
            this.stop = false;
            this.start = head;
            this.recurse(head, left, right);
            return head;
        }

        private void recurse(ListNode end, int left, int right){
            // recurse until start and end both reach the right start and end
            // listnodes in the sublist that needs to be reversed
            // base case
            if (right == 1){
                return;
            }

            end = end.next;

            if (left > 1){
                this.start = this.start.next;
            }

            this.recurse(end, left-1, right-1);

            // finish reversing
            if (this.start == end || end.next == this.start){
                this.stop = true;
            }

            // if not finish reversing yet, swapping values
            if (!this.stop){
                int startVal = this.start.val;
                this.start.val = end.val;
                end.val = startVal;

                // update left pointer so that it swaps with the right
                // value when right pointer update during the backtrack
                this.start = this.start.next;
            }
        }
    }

     // iterative
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
