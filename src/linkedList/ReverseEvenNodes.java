/*Given a singly linked list, reverse nodes at even indices.
 * Hint: use 2 lists. And think about {n1,n2,n3,n4} and {n1,n2,n3}.
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: Constant, O(1).
 */
package linkedList;

public class ReverseEvenNodes {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList mylist = new MyLinkedList();
		mylist.addLast(2);
		mylist.addLast(4);
		mylist.addLast(8);
		mylist.addLast(16);
		mylist.addLast(32);

		System.out.println("Unsorted linkedList is: ");
		mylist.printList();
		
		//apply reverseEvenNodes
		ReverseEvenNodesSolution ren = new ReverseEvenNodesSolution();
     	mylist.head = ren.reverse(mylist.head);

		System.out.println("\nReversed LinkedList is: ");
		mylist.printList();

	}

}

class ReverseEvenNodesSolution{
	//Extract even nodes and arrange them to be in reverse order.
	MyLinkedList.Node extract_even_nodes(MyLinkedList.Node head){
		MyLinkedList.Node extractedHead = null;
		MyLinkedList.Node odd = head;
		 
			while(odd != null && odd.next != null){
				MyLinkedList.Node even = odd.next;
				odd.next = even.next; // n1.next is n3, not n2;
				//Push at the head of the new even list.
				even.next = extractedHead;
				extractedHead = even;
				//update odd and even
				odd = odd.next;
			}
			return extractedHead;
		}
		
		//Merge the odd list and the even list.
	MyLinkedList.Node merge(MyLinkedList.Node h1, MyLinkedList.Node h2){
			MyLinkedList.Node merged_head = h1;
			
			//odd elements always >= even elements.
			while(h2 != null){
				MyLinkedList.Node temp = h2; //h2 = temp,
				//update the head pointer h2.
				h2 = h2.next ;               //h2 = n4,
				
				temp.next = h1.next;  //so n2 -> n3,
				h1.next = temp;      //so n1 -> n2,
				
				// update the head pointer h1.
				h1 = temp.next;      //let h1 = n3,
			}
			return merged_head;
		}
		
		MyLinkedList.Node reverse(MyLinkedList.Node h){
			//Base case: no need to call other functions
			if(h == null || h.next == null || h.next.next == null || h.next.next.next == null){
				return h;
			}
			MyLinkedList.Node even_head = extract_even_nodes(h);
			MyLinkedList.Node result = merge(h, even_head);
			return result;
		}
}