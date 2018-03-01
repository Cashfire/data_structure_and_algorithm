/*
 * Given head pointer of a linked list, sort the linked list (in ascending order) 
 * and return new head pointer of the sorted linked list.
 * Space complexity: insertion sort (but runtime is O(n^2))
 */
package linkedList;

public class InsertionSortLinkedList {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList mll = new MyLinkedList();
		mll.addLast(29);
		mll.addLast(23);
		mll.addLast(82);
		mll.addLast(11);
		System.out.println("The linkedList is: ");
		mll.printList();
		mll.insertionSort();
		System.out.println("\nThe sorted linkedList is: ");
		mll.printList();
	}

}

class MyLinkedList{
	Node head;
	class Node{
		int value;
		Node next;
		Node(int v) {this.value = v;}
	}
	
	void printList(){
		Node temp = head;
		while(temp != null){
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.println("");
	}
	
	void addLast(int v){
		Node new_node = new Node(v);
		//if the linkedList is empty and head is null.
		if(head == null) { 
			new_node.next = this.head;
			this.head = new_node;
			return;
		}
		Node temp = head;
		// move the temp to the end node.
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = new_node;
		return;
	}
	
	Node insertionSort(){
		Node sorted_head = null;
		Node i = this.head;
		//move i from head to end.
		while(i != null){
			//use temp because sorted_insert() will change i;
			Node temp = i.next;
			sorted_head = insert(sorted_head, i);
			i = temp;
		}
		this.head = sorted_head;
		return sorted_head;
	}

	private Node insert(Node sh, Node n) {
		//if sorted_head==null, means the sorted linkedlist is empty.
        // make the n.next = null, and point sorted_head to n;
		//keep the head is of the smallest value.
		if(sh == null || n.value <= sh.value){
			n.next = sh;
			return n; //this will update the sorted_head as n.
		}
		// if the sorted linkedlist is not empty, and n > sorted_head.
		Node curr = sh;
		// move forward before the bigger value
		while(curr.next != null && curr.next.value < n.value){
			curr = curr.next;
		}
		n.next = curr.next;
		curr.next = n;
		return sh; //this will not update the sorted_head in the insertionSort().
	}
	
	
}




