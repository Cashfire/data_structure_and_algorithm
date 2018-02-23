package linkedList;

import java.util.HashSet;

public class RemoveDuplicatesFromLinkedList {
	static LinkedListNode head;	
	static class LinkedListNode{
		int value;
		LinkedListNode next;
		LinkedListNode(int x) {value = x;}
		public String toString() {return "Node:" + value;}
	}
	
	/*
	 * runtime complexity: O(n^2), space complexity: O(1).
	 */
	void remove_duplicates_unsorted(){
		LinkedListNode i = head, j = null;
		// the loop ends when the previous of curr is the last node, and curr == null.
		while(i != null){
			LinkedListNode prev = i;
			j = i.next;
			while(j != null){
				if(i.value == j.value){
					prev.next = j.next;
					j = j.next;
				}else{
					prev = j;
					j = j.next;
				}
			}
			i = i.next;
		}
	}
	
	/*
	 * runtime complexity: O(n), space complexity: O(n).
	 */
	void remove_duplicates_hashSet(){
		HashSet<Integer> hs = new HashSet<Integer>();
		LinkedListNode curr = head;
		hs.add(curr.value);
		//check if hs contains curr.next
		while(curr.next != null){
			if(hs.contains(curr.next.value)){
				curr.next = curr.next.next;
			}else{
				hs.add(curr.next.value);
				curr = curr.next;
			}
		}
	}
	
	void printList(){
		LinkedListNode node = head;
		while(node != null){
			System.out.print(node.value + " ");
			node = node.next;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesFromLinkedList ll = new RemoveDuplicatesFromLinkedList();
		ll.head = new LinkedListNode(1);
		ll.head.next  = new LinkedListNode(2);
		ll.head.next.next =  new LinkedListNode(1);
		ll.head.next.next.next =  new LinkedListNode(3);
		ll.head.next.next.next.next =  new LinkedListNode(2);

		System.out.println("LinkedList Before removing duplicates: \n");
		ll.printList();
		
		System.out.println("");
//		ll.remove_duplicates_unsorted();
      
		ll.remove_duplicates_hashSet();
		System.out.println("Linked List after removing duplicates : \n ");
        ll.printList();
	}

}







