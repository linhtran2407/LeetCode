import java.util.*;

// Do not edit the class below except for the insertKeyValuePair,
// getValueFromKey, and getMostRecentKey methods. Feel free
// to add new properties and methods to the class.
class LRUCACHE {
  static class LRUCache {
    int maxSize;
		Map<String, Node> map = new HashMap<String, Node>();
		DoublyLinkedList list = new DoublyLinkedList();
		
    public LRUCache(int maxSize) {
      this.maxSize = maxSize > 1 ? maxSize : 1;
    }

    public void insertKeyValuePair(String key, int value) {
      // key exists or not reach the limit size yet
			if (this.map.containsKey(key)){
				// update value
				this.map.get(key).value = value;
				// move node to head
				list.setHead(this.map.get(key));
				return;
			}
			
			if (map.size() == this.maxSize){
				// evict least used
				map.remove(list.tail.key);
				list.removeTail();
			}
	
			// insert new
			Node newNode = new Node(key, value);
			map.put(key, newNode);
			list.setHead(newNode);
    }

    public LRUResult getValueFromKey(String key) {
      if (map.containsKey(key)){
				LRUResult res = new LRUResult(true, map.get(key).value);
				// update most recently used cache
				list.setHead(map.get(key));
				return res;
			}
			
      return new LRUResult(false, -1);
    }

    public String getMostRecentKey() {
			if (list.head != null){
				return list.head.key;
			}
      return "";
    }
  }
	
	static class Node {
		String key;
		int value;
		Node prev = null;
		Node next = null;
		
		public Node (String key, int value){
			this.key = key;
			this.value = value;
		}
		
		public Node (String key, int value, Node prev, Node next){
			this.key = key;
			this.value = value;
			this.prev = prev;
			this.next = next;
		}
		
		public void removeBindings(){
			if (prev != null){
				prev.next = next;
			}
			if (next != null){
				next.prev = prev;
			}
			
			prev = null;
			next = null;
		}
	}
	
	static class DoublyLinkedList{
		Node head = null;
		Node tail = null;
		
		public void setHead (Node node){
			if (head == node){
				return;
			} else if (this.head == null){
				// one node
				this.head = node;
				this.tail = node;
			} else if (head == tail){
				head.prev = node;
				head = node;
				head.next = tail;
			} else {
				if (tail == node){
					removeTail();
				}
				node.removeBindings();
				this.head.prev = node;
				node.next = this.head;
				this.head = node;
			}
		}
		

		
		public void removeTail(){
			if (tail == null){
				return;
			} else if (tail == head){
				// one node
				this.head = null;
				this.tail = null;
			} else {
				tail = tail.prev;
				tail.next = null;
			}

		}
	}

  static class LRUResult {
    boolean found;
    int value;

    public LRUResult(boolean found, int value) {
      this.found = found;
      this.value = value;
    }
  }
}
