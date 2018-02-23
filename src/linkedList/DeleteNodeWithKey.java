/*
 * Given head of a linked list and a key, [7,14, 21, 28, 35, 42] head=7, key=28
 * delete node with this given key from the linked list. [7,14, 21, 35, 42]
 * time: O(n), space:O(1).
 */
package linkedList;


public class DeleteNodeWithKey {
	
	static LinkedListNode head;	
	static class LinkedListNode{
		int value;
		LinkedListNode next;
		LinkedListNode(int x) {value = x;}
		public String toString() {return "Node:" + value;}
	}
	void printList(LinkedListNode head_node){
		while(head_node != null){
			System.out.print(head_node.value + " ");
			head_node = head_node.next;
		}
	}
	
	LinkedListNode delete_node(LinkedListNode head, int key){
		LinkedListNode pre = null;
		LinkedListNode curr = head;
		while(curr != null){
			if(curr.value == key){
				break;
			}
			//move forward to the end or until found the key.
			pre = curr;
			curr = curr.next;
		}
		//if node to be delete is head node
		if(curr == head){
			return head.next;
		}else if(curr == null){ //if the linkedlist doesn't contain that key
			return head;
		}else{
			pre.next = curr.next;
			return head;
		}
	}
	
	public static void main(String[] args){
		int k = 28;
		DeleteNodeWithKey ll = new DeleteNodeWithKey();
		ll.head = new LinkedListNode(7);
		ll.head.next  = new LinkedListNode(14);
		ll.head.next.next =  new LinkedListNode(21);
		ll.head.next.next.next =  new LinkedListNode(28);
		ll.head.next.next.next.next =  new LinkedListNode(35);
		ll.head.next.next.next.next.next =  new LinkedListNode(42);
		
		System.out.println("LinkedList Before deletion: \n");
		ll.printList(head);
		
		System.out.println("");
		
		System.out.println("LinkedList after deletion: \n ");
		ll.printList(ll.delete_node(head, k));
	}
}
