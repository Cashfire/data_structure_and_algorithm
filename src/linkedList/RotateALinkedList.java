/*
 * Given head node of a singly linked list and an integer 'n', rotate linked list by 'n'.
 * For example, {1,2,3,4,5} and n= 2 or 7, after rotation: {4,5,1,2,3}.
 * if n = -1 or 4 or -6, after rotation: {2,3,4,5,1}
 * 
 *Runtime Complexity: Linear, O(m).where 'm' is the length of linked list.
 *Memory Complexity: Constant, O(1).
 */
package linkedList;

public class RotateALinkedList {
	
	private int find_length(MyLinkedList.Node head){
		int len = 0;
		while(head != null){
			len++;
			head = head.next;
		}
		
		if(head == null){System.out.println("head is null now.");}	
		
		return len;
	}
	
	private int adjust_rotations(int n, int len){
		//if len=5, n=2 or 7, rotation index should be 2.
		// if n= -2, rotation index should be 3.
		// if n = -6 or (-1), rotation index should be 4.
		n = n%len;
		
		if(n < 0){
			n = n + len;
		}
		return n;
	}
	
	MyLinkedList.Node rotate_list(int n, MyLinkedList.Node head){
		//base case: no need to rotate
		if(head == null|| head.next== null || n==0){
			return head;
		}
		int len = find_length(head);
		n = adjust_rotations(n, len);
		
		//for example, {1,2,3,4,5} and n= 2, after rotation: {4,5,1,2,3}.
		//Firstly, let the temp pointer rest on 3 (the node prior to 4).
		int count = len - n -1; //if count=(len-n), temp will point to 4.
		
		MyLinkedList.Node temp = head;
		while(count > 0){
			temp = temp.next;
			count --;
		}
		
		MyLinkedList.Node new_head = temp.next;
		temp.next = null;
		
		//add the linkedlist from new_head to tail, to the old head.
		MyLinkedList.Node tail = new_head;
		while(tail.next != null){
			tail = tail.next;
		}
		tail.next = head;
		
		return new_head;
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
		RotateALinkedList rll = new RotateALinkedList();
		int k = -6;
     	mylist.head = rll.rotate_list(k, mylist.head);

		System.out.println("\nRotated LinkedList is: ");
		mylist.printList();

	}

}

