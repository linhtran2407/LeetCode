public class SortList {

    // Runtime: 6 ms, faster than 86.34% of Java online submissions for Sort List.
// Memory Usage: 47.6 MB, less than 56.53% of Java online submissions for Sort List.

    public class ListNode {
        int val;
        ListNode next;
        public ListNode (int val, ListNode next){
            this.val = val;
            this.next = next;
        }

        public ListNode (){}
        public ListNode (int val){
            this.val = val;
        }
    }

    public ListNode sortList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode mid = getMid(head);
        ListNode first = sortList(head);
        ListNode second = sortList(mid);
        return merge(first, second);
    }

    private ListNode getMid(ListNode head){
        ListNode prevMid = null;
        while (head != null && head.next != null){
            prevMid = (prevMid == null)? head : prevMid.next;
            head = head.next.next;
        }

        ListNode mid = prevMid.next;
        prevMid.next = null;
        return mid;
    }

    private ListNode merge (ListNode left, ListNode right){
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while (left != null && right != null){
            if (left.val < right.val){
                curr.next = new ListNode(left.val);
                left = left.next;
            } else {
                curr.next = new ListNode(right.val);
                right = right.next;
            }
            curr = curr.next;
        }

        curr.next = (left == null)? right : left;

        return dummy.next;

    }
}
