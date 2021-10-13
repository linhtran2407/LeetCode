import java.util.*;
/*
     * @author: Linh Tran
     * 
     * @version: Oct 10th, 2021
     */
class RemoveKthNodeFromEnd {
  public static void removeKthNodeFromEnd(LinkedList head, int k) {
		int len = length(head);
		
		if (k < 0 || k > len){
			return;
		}
		
		int count = len-k;
		int index = 0;
		LinkedList cur = head;
		LinkedList prev = null;
		
		while (index != count){
			
			prev = cur;
			cur = cur.next;
			index++;
		}
		
		if (prev != null){
			prev.next = cur.next;
		} else {
			// remove head
			head.value = head.next.value;
			head.next = head.next.next;
		}
  }
	
	private static int length(LinkedList head){
		int len = 0;
		LinkedList cur = head;
		while (cur != null){
			len++;
			cur = cur.next;
		}
		return len;
	}

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
