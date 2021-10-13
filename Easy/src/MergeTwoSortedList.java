import java.util.*;
public class MergeTwoSortedList {
      // This is an input class. Do not edit.
  public static class LinkedList {
    int value;
    LinkedList next;

    LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
    if (headOne == null && headTwo == null){
			return null;
		}
		
		LinkedList cur1 = headOne;
		LinkedList cur2 = headTwo;
		LinkedList res = new LinkedList(0);
		LinkedList cur = res;
		
		while (cur1 != null || cur2 != null){
			int val1 = cur1 != null? cur1.value : Integer.MAX_VALUE;
			int val2 = cur2 != null? cur2.value : Integer.MAX_VALUE;
			if (val1 <= val2){
				cur.next = new LinkedList(val1);
				cur1 = cur1.next;
			} else {
				cur.next = new LinkedList(val2);
				cur2 = cur2.next;
			}
			cur = cur.next;
		}
		
    return res.next;
  }
}
