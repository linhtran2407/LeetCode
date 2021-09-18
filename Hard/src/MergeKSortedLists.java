import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {

    /*
    @author: Linh Tran
    @version: Sep 17th, 2021

    Runtime and usage info:
    Runtime: 9 ms, faster than 31.60% of Java online submissions for Merge k Sorted Lists.
    Memory Usage: 44.2 MB, less than 25.59% of Java online submissions for Merge k Sorted Lists.
 */

     // Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            // implement min heap
            Comparator<ListNode> comp = new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val;
                }
            };

            Queue<ListNode> pq = new PriorityQueue<ListNode>(comp);
            // initialize heap with k head nodes in k lists
            for (ListNode l: lists){
                if (l != null){
                    pq.offer(l);
                }
            }

            ListNode head = new ListNode(); // dummy head
            ListNode curr = head;

            while (!pq.isEmpty()){
                // build result with min node in pq
                curr.next = pq.poll();
                curr = curr.next;

                ListNode nextNodeInList = curr.next;
                if (nextNodeInList != null){
                    pq.offer(nextNodeInList);
                }
            }


            return head.next;
        }
     }
}
