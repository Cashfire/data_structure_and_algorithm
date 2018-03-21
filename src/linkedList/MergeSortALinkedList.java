/*Given head pointer of a linked sort, sort linked list (in ascending order) 
 * using merge sort and return new head pointer of sorted linked list.
 * For example, sort {5,4,10,8,7,9} as: {4,5,7,8,9,10}.
 * Hint: divide and conquer.
 */
package linkedList;

import linkedList.MyLinkedList.Node;

public class MergeSortALinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList li = new MyLinkedList();
		//create an unsorted linkedlist: {5,4,10,8,7,9}
		li.addLast(5);
		li.addLast(4);
		li.addLast(10);
		li.addLast(8);
		li.addLast(7);
		li.addLast(9);
		System.out.println("Unsorted linkedList is: ");
		li.printList();
		
		//apply merge sort
		MergeSort ms = new MergeSort();
		li.head = ms.merge_sort(li.head);
		//must assign "ms.merge_sort(li.head)" to li.head, 
		//otherwise the list is {5 7 8 9 10}. WHY???
		System.out.println("\nSorted LinkedList is: ");
		li.printList();
	}

}

class MergeSort{
	public MyLinkedList.Node merge_sort(MyLinkedList.Node h){
		//Base case: no need to sort if the list is empty or just has 1 element.
		if(h == null || h.next == null){
			return h;
		}
		
		//Divide into halves with recursion.
		MyLinkedList.Node middle = findMiddle(h);
		MyLinkedList.Node secondHalfHead = middle.next;
		//set the middle's next to null;
		middle.next = null;	
		
		//Now the left list is a new LinkedList from Node h to Node middle,
		// and the right half is a LinkedList with the head of Node secondHalfHead.
		//Apply merge_sort on the right and left lists
		MyLinkedList.Node leftHead = merge_sort(h);
		MyLinkedList.Node rightHead = merge_sort(secondHalfHead);
		//sort and combine the left and right lists.
		MyLinkedList.Node sortedHead = sort(leftHead, rightHead);
		return sortedHead;		
	}
	
	
	@SuppressWarnings("unused")
	private Node sort(Node lh, Node rh) {
		// Base case: if the leftHead or rightHead is null
		if(lh == null){
			return rh;
		}
		if(rh == null){
			return lh;
		}
		 
		//compare the heads of each list, and always take the smaller one.
		// firstly, get the newHead.
		Node newHead = null;
		if(lh.value <= rh.value){
			newHead = lh;
			lh = lh.next;
		}else{
			newHead = rh;
			rh = rh.next;
		}
		
		//second, compare each head until one list is empty.
		Node curr = newHead;
		while(lh != null && rh != null){
			if(lh.value <= rh.value){
				curr.next = lh;
				curr = curr.next;
				lh = lh.next;
			}else{
				curr.next = rh;
				curr = curr.next;
				rh = rh.next;
			}
		}
		
		//thirdly, add the other list which is not empty yet.
		if(lh != null){
			curr.next = lh;
		}else if(rh != null){
			curr.next = rh;
		}
		
		return newHead;
	}



	private Node findMiddle(Node h) {
		// TODO Auto-generated method stub
		//Base case
		if(h == null){
			return h;
		}
		Node fastPointer = h.next;
		Node slowPointer = h;
		//Move fastPointer 2 steps and slowPointer 1 step every time.
		while(fastPointer != null){
			fastPointer = fastPointer.next;
			if(fastPointer != null){
				fastPointer = fastPointer.next;
				slowPointer = slowPointer.next;
			}
		}	
		return slowPointer;
	}



	public void divide(MyLinkedList.Node h){
		
	}
}