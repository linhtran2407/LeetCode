public class SplitListToParts {

    /*
        @author: Linh Tran
        @version: Jun 10th, 2021

        Runtime and usage info of brute force solution:
        Runtime: 0 ms, faster than 100.00% of Java online submissions for Split Linked List in Parts.
        Memory Usage: 39.4 MB, less than 22.96% of Java online submissions for Split Linked List in Parts.
     */

     // Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    // brute force:
    class Solution {
        public ListNode[] splitListToParts(ListNode head, int k) {
            // initialize the result as an array of k sub-linked list
            // go through the array once, for each linked list, put a place holder (new Linked List)
            // to indicate that how many listnodes should be in each sub-linked list
            // go through the array twice, put the nodes into each element (sub ll) of the output
            // according to the indicated size above
            // TC: O(2N) -> O(N)
            // SC: O(N+k) -> O(N)

            ListNode[] res = new ListNode[k];
            if (head == null){
                return res;
            }

            // indicate size of each sub ll
            int[] sizes = new int[k];
            ListNode curr = head;
            int index = 0;
            while(curr != null){
                // increment the size of subLL at each element of the output
                sizes[index]++;

                // update
                curr = curr.next;
                index = (index+1) % k; // to circulate
            }

            // reset current node and index
            curr = head;
            index = 0;

            // put the nodes into each sub LL based on the size indicated as the value
            // of each sub ll's head
            while(curr != null){
                int size = sizes[index]; // size of the current sub ll

                ListNode pointer = null; // used to traverse through sub ll
                // build each sub ll
                for (int i=0; i<size; i++){
                    // set node to be the head if there isn't a head of sub ll yet
                    // otherwise connect with the previous node in the sub ll
                    if (res[index] == null){
                        res[index] = new ListNode(curr.val);
                        pointer = res[index];
                    } else {
                        ListNode nextNode = new ListNode(curr.val);
                        pointer.next = nextNode;
                        pointer = nextNode;
                    }

                    curr = curr.next;
                }

                index++;
            }

            return res;
        }
    }
}
