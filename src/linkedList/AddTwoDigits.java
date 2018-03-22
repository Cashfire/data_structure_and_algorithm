/*Given head pointers of two linked lists, 
 * in which each node's value represents a digit, 
 * add them and return the resulting linked list.
 * For example, {1,0,9,9} + {7, 3, 2} ={8 3 1 0 1}.
 * Runtime Complexity: Linear, O(n), which is based on the length of the linked lists.
 * Memory Complexity: Constant, O(1)
 */
package linkedList;

public class AddTwoDigits {
	
	private MyLinkedList.Node addition(MyLinkedList.Node h1, MyLinkedList.Node h2){
		MyLinkedList.Node new_head = null;
		MyLinkedList.Node new_tail = null;
		MyLinkedList mll = new MyLinkedList();
		
		int carry = 0;
		
		while(h1 != null || h2!=null || carry >0){
			int first = (h1 == null ? 0 : h1.value);
			int second = (h2 == null ? 0 : h2.value);
			int sum = first + second + carry;
			MyLinkedList.Node result = mll.new Node(sum / 10);
			result.value = sum % 10;
			carry = sum / 10;
			// set first result as new_head, append other results as new_tail.next;
			if(new_head == null){
				new_head = result;
			}else{
				new_tail.next = result;
			}
			//update new_tail.
			new_tail = result;
			//updating h1 and h2.
			if(h1 != null){ h1 = h1.next; }
			if(h2 != null){ h2 = h2.next; }
		}
		return new_head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList list_one = new MyLinkedList();
		list_one.addLast(1);
		list_one.addLast(0);
		list_one.addLast(9);
		list_one.addLast(9);
		
		MyLinkedList list_two = new MyLinkedList();
		list_two.addLast(7);
		list_two.addLast(3);
		list_two.addLast(2);
		
		AddTwoDigits atd = new AddTwoDigits();
		MyLinkedList new_list = new MyLinkedList();
		new_list.head = atd.addition(list_one.head, list_two.head);
		new_list.printList();
		
		
		
	}

}
