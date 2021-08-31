public class ReverseLinkedListII {

/*
    @author: Linh Tran
    @version: Aug 30, 2021

    Runtime and usage info of the first solution:
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
    Memory Usage: 38.7 MB, less than 7.54% of Java online submissions for Reverse Linked List II.

    Runtime and usage info of the second solution:
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Distance Between BST Nodes.
    Memory Usage: 36.7 MB, less than 33.21% of Java online submissions for Minimum Distance Between BST Nodes.
*/

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

    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            // special case
            if (head == null){return null;}

            // move pointers until they reach the proper starting point
            ListNode cur = head, prev = null;
            while (left > 1){
                prev = cur;
                cur = cur.next;
                left--;
                right--;
            }

            // start reversing
            ListNode prevLeft = prev, leftNode = cur;
            while (right > 0){
                ListNode nextCur = cur.next;
                cur.next = prev;
                prev = cur;
                cur = nextCur;
                right--;
            }

            // connect the sub-linkedlist with the remaining part in linked list
            // in a proper way
            if (prevLeft != null){
                prevLeft.next = prev;
            } else {
                head = prev;
            }

            leftNode.next = cur;

            return head;
        }
    }
}
