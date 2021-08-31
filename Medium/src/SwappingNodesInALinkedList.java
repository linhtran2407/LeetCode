import java.util.HashMap;
import java.util.Map;

public class SwappingNodesInALinkedList {

    /*
    @author: Linh Tran
    @version: Aug 8th, 2021

    Runtime and usage info of the solution:
    Runtime: 26 ms, faster than 5.46% of Java online submissions for Swapping Nodes in a Linked List.
    Memory Usage: 53 MB, less than 99.10% of Java online submissions for Swapping Nodes in a Linked List.
 */


     // Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    class Solution1 {
        public ListNode swapNodes(ListNode head, int k) {
            // idea:
            // store the index and node at that index in a table
            // get the value at index(th) from start and end of the linked list
            // swap the values
            // TC: O(N) -> for building the map mainly
            // SC: O(N) -> for the map

            // key: index, val: node at that index
            Map<Integer, ListNode> map = new HashMap<>();
            ListNode curr = head;
            int index = 1;

            // build the map
            while(curr != null){
                map.put(index++, curr);
                curr = curr.next;
            }

            // get and swap the values
            int size = map.size();
            int val1 = map.get(k).val;
            int val2 = map.get(size-k+1).val;
            ListNode node1 = map.get(k);
            node1.val = val2;
            ListNode node2 = map.get(size-k+1);
            node2.val = val1;

            return head;
        }
    }

    class Solution2 {
         // 3 pass solution
        // k(th) node from the end is at index n-k (index base 1)
        // TC: O(N)
        // SC: O(1)
        public ListNode swapNodes(ListNode head, int k) {
            int n = 0; // length of linked list

            // find length of linked list
            ListNode curr = head;
            while (curr != null){
                n++;
                curr = curr.next;
            }

            // set the start node
            ListNode front = head;
            for (int i=1; i<k; i++){
                front = front.next;
            }

            // set the end node
            ListNode end = head;
            for (int i=1; i<=n-k; i++){
                end = end.next;
            }

            // swap start and end nodes
            int value = front.val;
            front.val = end.val;
            end.val = value;

            return head;
        }
    }
}
