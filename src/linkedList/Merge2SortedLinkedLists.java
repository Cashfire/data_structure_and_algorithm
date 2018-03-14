/*
 * Given two sorted linked lists, 
 * merge them such that resulting linked list is also sorted.
 * Runtime Complexity: O(m + n) , Memory complexity: Constant, O(1).
 */

package linkedList;

public class Merge2SortedLinkedLists {
	static MyLinkedList.Node merge_sorted(MyLinkedList.Node head1, MyLinkedList.Node head2){
		// if both lists are empty then merged list is also empty,
		// if one of the lists is empty then other is the merged list.
		if(head1 == null){
			return head2;
		}else if(head2 == null){
			return head1;
		}
		
		MyLinkedList.Node mergedHead = null;
		if(head1.value <= head2.value){
			mergedHead = head1;
			head1 = head1.next;
		}else{
			mergedHead = head2;
			head2 = head2.next;
		}
		
		MyLinkedList.Node mergedTail = mergedHead;
		int count = 1;
		while(head1 != null && head2 != null){
			if(head1.value <= head2.value){
				mergedTail.next = head1;
				head1 = head1.next;
				mergedTail = mergedTail.next;
				count ++;
			}else{
				mergedTail.next = head2;
				head2 = head2.next;
				mergedTail = mergedTail.next;
				count ++;
			}
			System.out.println("The " + count + " element is: " + mergedTail.value);
		}
		
		if(head1 != null){
			mergedTail.next = head1;
			mergedTail = mergedTail.next;

		}else if(head2 != null){
			mergedTail.next = head2;
			mergedTail = mergedTail.next;
			
		}
		
		return mergedHead;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList ll1 = new MyLinkedList();
		ll1.addLast(4);
		ll1.addLast(8);
		ll1.addLast(15);
		ll1.addLast(19);
//		System.out.println("The linkedList ll1 is: ");
//		ll1.printList();
//		System.out.println("The head of ll1 is: " + ll1.head.value);
		MyLinkedList ll2 = new MyLinkedList();
		ll2.addLast(7);
		ll2.addLast(9);
		ll2.addLast(10);
		ll2.addLast(16);
//		System.out.println("\nThe linkedList ll2 is: ");
//		ll2.printList();
//		System.out.println("The head of ll2 is: " + ll2.head.value);
		
		merge_sorted(ll1.head, ll2.head);
	}		
}
