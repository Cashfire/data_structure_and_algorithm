/*
 * Make a deep copy of the given linked list with 
 * each node having two pointers:  'next' and 'arbitrary_pointer'.
 * For example: n1(value = 7, next = n2, arbitrary_point = n3),
 *             n2(value = 14, next = n3, arbitrary_point = null),
 *             n3(value = 21, next = null, arbitrary_point = n1).
 */
package linkedList;

import java.util.HashMap;


public class DeepCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NodeWithTwoPointers n1 = new NodeWithTwoPointers(7);
		NodeWithTwoPointers n2 = new NodeWithTwoPointers(14);
		NodeWithTwoPointers n3 = new NodeWithTwoPointers(21);
		n1.next = n2;
		n2.next = n3;
		n1.arbitrary_Pointer = n3;
		n2.arbitrary_Pointer = null;
		n3.arbitrary_Pointer = n1;
		System.out.println("The old LinkedList: ");
		NodeWithTwoPointers temp = n1;
		while(temp != null){
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.println("");
		DeepCopySolution dcs = new DeepCopySolution();
		//Apply the HashMapApproah
		NodeWithTwoPointers approah1 = dcs.hashMapApproah(n1);	
		System.out.println(approah1.next.arbitrary_Pointer == null 
				&& approah1.next.next.arbitrary_Pointer == approah1);
		
		//Apply the approah2.
		NodeWithTwoPointers approah2 = dcs.approah2(n1);
		System.out.println(approah2.next.arbitrary_Pointer == null 
				&& approah2.next.next.arbitrary_Pointer == approah2);
	}
}

class NodeWithTwoPointers{
	int value;
	NodeWithTwoPointers next;
	NodeWithTwoPointers arbitrary_Pointer;
	NodeWithTwoPointers(int v) { this.value = v;}	
}

class DeepCopySolution{
	/*
	 * Use hashMap to store the (oldNode, newNode).
	 * TC: Linear, O(n). SC: Linear, O(n).
	 */
	NodeWithTwoPointers hashMapApproah(NodeWithTwoPointers head){
		if(head == null){
			return null;
		}
		
		NodeWithTwoPointers curr = head;
		NodeWithTwoPointers newPre = null;
		NodeWithTwoPointers newHead = null;
		HashMap<NodeWithTwoPointers, NodeWithTwoPointers> hm =
				new HashMap<NodeWithTwoPointers, NodeWithTwoPointers>();
		//create new nodes but pointing to the original nodes.
		while(curr != null){
			NodeWithTwoPointers newNode = new NodeWithTwoPointers(curr.value);
			newNode.arbitrary_Pointer = curr.arbitrary_Pointer;
			
			if(newPre != null){
				newPre.next = newNode;
			}else{
				newHead = newNode;
			}
			newPre = newNode; 
			
			hm.put(curr, newNode);			
			curr = curr.next;		
		}
		//updating the new nodes' arbitrary pointers.
		NodeWithTwoPointers newCurr = newHead;
		while(newCurr != null){
			if(newCurr.arbitrary_Pointer != null){
				newCurr.arbitrary_Pointer = hm.get(newCurr.arbitrary_Pointer);
			}
			newCurr = newCurr.next;
		}
		return newHead;
	}
	
	/*
	 * insert new nodes as next of the copied nodes in the original LinkedList, 
	 * and then separate as 2 LinkedLists.
	 */
	NodeWithTwoPointers approah2(NodeWithTwoPointers head){
		
		NodeWithTwoPointers curr = head;
		while(curr != null){
			NodeWithTwoPointers newNode = new NodeWithTwoPointers(curr.value);
			newNode.next = curr.next;
			curr.next = newNode;
			curr = newNode.next;
		}
		
		//setting arbitrary pointers for those new nodes.
		curr = head;
		while(curr != null){
			if(curr.arbitrary_Pointer != null){
				curr.next.arbitrary_Pointer = curr.arbitrary_Pointer.next;
			}
			curr = curr.next.next;
		}
		
		//separate into 2 lists
		NodeWithTwoPointers newHead = null;
		newHead = head.next;
		NodeWithTwoPointers copyNode = newHead;
		curr = head;
		while(curr != null){
			copyNode = curr.next;
			curr.next = copyNode.next;
			if(curr.next != null){
				copyNode.next = curr.next.next;
			}
			curr = curr.next;
		}
		return newHead;
	}
	

}
