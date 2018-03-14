/*
 * Given the head of a singly linked list and 'N', 
 * swap the head with Nth node. Return the head of the new linked list.
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: Constant, O(1).
 */

package linkedList;



public class SwapNthWithHead {
	
	Node head;
	
	class Node{
		int value;
		Node next;
		Node(int x) {this.value = x;}
		public String toString() {return "Node:" + value;}
	}
	void printList(){
		Node curr = this.head;
		while(curr != null){
			System.out.print(curr.value + " ");
			curr = curr.next;
		}
	}
	
	static Node swap(int n, SwapNthWithHead l){
		Node prev = null;
		Node nthNode = l.head;
		
		if(l.head == null || n ==1){
			return l.head;
		}
				
		for(int count = 1; count < n && nthNode != null; count++){
			prev = nthNode;
			nthNode = nthNode.next;
		}
		//Now nthNode is pointing to the nth node.
		//Let's swap nthNode with head.
		Node secondNode = l.head.next;
		l.head.next = nthNode.next;
		prev.next = l.head;
		nthNode.next = secondNode;		
		l.head = nthNode;
		return l.head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 4;
		SwapNthWithHead ll = new SwapNthWithHead();
		ll.head = ll.new Node(2);
		ll.head.next  = ll.new Node(4);
		ll.head.next.next =  ll.new Node(8);
		ll.head.next.next.next =  ll.new Node(16);
		ll.head.next.next.next.next =  ll.new Node(32);
		ll.head.next.next.next.next.next =  ll.new Node(64);
		
		System.out.println("LinkedList Before swap: \n");
		ll.printList();
        System.out.println("");
        swap(k, ll);
		System.out.println("LinkedList after swap: \n ");		
		ll.printList();
		
	}

}

