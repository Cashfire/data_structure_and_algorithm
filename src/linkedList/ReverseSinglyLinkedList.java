/* For example, [7,14,21,28]
 * Given the pointer to the head of a singly linked list, 7
 * reverse it and return the pointer to the head of reversed linked list. 28
 */
package linkedList;

import java.util.LinkedList;

public class ReverseSinglyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode n4 = new LinkedListNode(28);
		System.out.println(n4.next);
		LinkedListNode n3 = new LinkedListNode(21);
		n3.next = n4;
		LinkedListNode n2 = new LinkedListNode(14);
		n2.next = n3;
		LinkedListNode n1 = new LinkedListNode(7);
		n1.next = n2;
		
		solution s = new solution();
		//System.out.println(s.iterativeApproach(n1).toString());
		System.out.println(s.recursiveApproach(n1).toString());
	}

}

class LinkedListNode{
	int val;
	LinkedListNode next;
	LinkedListNode(int x) {val = x;}
	public String toString() {return "Node:" + val;}
}

class solution{
	/*
	 * Runtime complexity: O(n), memory complexity: O(1).
	 */
	LinkedListNode iterativeApproach(LinkedListNode head){
		LinkedListNode curr = head;
		LinkedListNode reversed = null;
		while(curr != null){
			LinkedListNode temp = curr.next;
			curr.next = reversed;
			reversed = curr;
			curr = temp;
		}
		return reversed;
	}
	
	/*
	 * Runtime complexity: O(n), memory complexity: O(n).
	 */
	LinkedListNode recursiveApproach(LinkedListNode head){
		if(head == null || head.next == null){
			return head; //if this node.next == null, it means it's the end of the linkedlist.
		}
		
		LinkedListNode reversedHead = recursiveApproach(head.next);
		head.next.next = head;
		head.next = null;
		return reversedHead;		
	}
}



