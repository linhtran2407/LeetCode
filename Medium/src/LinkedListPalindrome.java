import java.util.*;

class Program {
  // This is an input class. Do not edit.
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public boolean linkedListPalindrome(LinkedList head) {
		int len = length(head);
    if (len <= 1){
			return true;
		}
		
		// divide into 2 halves
		int halfLen = len/2;
		int count = 1;
		LinkedList cur = head, prev = null;
		while (count <= halfLen){
			LinkedList curNext = cur.next;
			cur.next = prev;
			prev = cur;
			cur = curNext;
			count++;
		}
		
		// prev is the last node in 1st half
		// cur is the first node in 2nd half
		// compare 2 halves
		if (len % 2 != 0) {
			cur = cur.next; // skip the middle if odd length
		}
		
		while (cur != null){
			if (cur.value != prev.value){
				return false;
			}
			cur = cur.next;
			prev = prev.next;
		}
		
    return true;
  }
	
	private int length(LinkedList head){
		int res = 0;
		LinkedList temp = head;
		while (temp != null){
			temp = temp.next;
			res++;
		}
		
		return res;
	}
}
