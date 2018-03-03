/*
 * Given head nodes of two linked lists that may or may not intersect, 
 * find out if they intersect and return the point of intersection; return null otherwise.
 * For example: {29, 23, 82, 12, 27} and {13, 4, 12, 27} will return 12
 */

package linkedList;

public class IntersectionPointOfTwoLists {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n11 = new Node(29);
		Node n12 = new Node(23);
		Node n13 = new Node(82);
		n11.next = n12;
		n12.next = n13;
		
		Node n21 = new Node(13);
		Node n22 = new Node(4);
		n21.next = n22;
		
		Node i1 = new Node(12);
		Node i2 = new Node(27);
		i1.next = i2;
		
		n13.next = i1;
		n22.next = i1;
		
		Node ip = intersectionPoint(n11, n21);
		ip.print();
	}

	static int size(Node h){
		int count = 0;
		Node temp = h;
		while(temp != null){
			temp = temp.next;
			count++;
		}
		return count;
	}
	
	static Node intersectionPoint(Node head1, Node head2){
		int size1 = size(head1);
		int size2 = size(head2);
		int sizeDiff = 0;
		Node temp1 = head1;
		Node temp2 = head2;
		
		if(size1 >= size2){
			sizeDiff = size1 - size2;
			while(sizeDiff != 0){
				temp1 = temp1.next;
				sizeDiff --;
			}
		}else{
			sizeDiff = size2 - size1;
			while(sizeDiff != 0){
				temp2 = temp2.next;
				sizeDiff --;
			}
		}	
		
		//move temp forward to find the intersection
		while(temp1 != null){
			if(temp1 == temp2){
				return temp1;
			}else{
				temp1 = temp1.next;
				temp2 = temp2.next;
			}		
		}
		return null;
	}
}


	
class Node{
	int value;
	Node next;
	Node(int v) {this.value = v; next = null;}
	
	void print(){
		System.out.println("Node value: " + value);
		System.out.println("Next node: "+ next.value );
	}
}	
