/*
 * Given a singly linked list and an integer 'k', reverse every 'k' elements. 
 * If k <= 1, then input list is unchanged. 
 * If k >= n (n is the length of linked list), then reverse the whole linked list.
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: Constant, O(1).
 */
package linkedList;

public class ReverseEveryKnodes {

	MyLinkedList.Node reverse_every_k(int k ,MyLinkedList.Node head){
		//Base case: no need to change.
		if(head == null || k <= 1){
			return head;
		}
		//reversed_head will be the Kth node from head, after first reversion.
		MyLinkedList.Node reversed_head = null;
		MyLinkedList.Node reversed_tail = null;
		
		while(head != null){
			//when reverse every k elements, the current_tail will be their original head.
			MyLinkedList.Node current_head = null;
			MyLinkedList.Node current_tail = head;
			int n = k;
			while(head != null && n >0){
				MyLinkedList.Node temp = head.next; //points to the to-do node
				head.next = current_head;
				current_head = head;
				//move head to the to-do node
				head = temp;
				n--;
			}
			//after first time reversion, update reversed_head to be the Kth node.
			if(reversed_head == null){
				reversed_head = current_head;
			}
			//from second reversion, put together with the previously reversed LinkedList.
			if(reversed_tail != null){
				reversed_tail.next = current_head;
			}
			//update reversed_tail after each reversion.
			reversed_tail = current_tail;
		}
		return reversed_head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList mylist = new MyLinkedList();
		mylist.addLast(1);
		mylist.addLast(2);
		mylist.addLast(3);
		mylist.addLast(4);
		mylist.addLast(5);

		System.out.println("Unroated linkedList is: ");
		mylist.printList();
		
		//apply rotate
		ReverseEveryKnodes rek = new ReverseEveryKnodes();
		int k = 3;
     	mylist.head = rek.reverse_every_k(k, mylist.head);

		System.out.println("\nReversed LinkedList is: ");
		mylist.printList();

	}

}
