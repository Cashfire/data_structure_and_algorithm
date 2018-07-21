/*
 * Convert a binary tree to a doubly linked list such that 
 * the order of the doubly linked list is the same as an in-order traversal of the binary tree.
 * TC: Linear, O(n). 
 * SC: Linear, O(h). Recursive solution has O(h) memory complexity as it will consume memory on the stack 
 * up to the height of binary tree 'h'. It will be O(log n) for balanced tree and in worst case can be O(n).
 */
package trees;

import java.util.ArrayList;

public class ConvertBTtoDLL {
	Node convert_to_doubly_linked_list(Node root){
		if(root == null) return null;
		
		Node list1 = convert_to_doubly_linked_list(root.left);
		Node list2 = convert_to_doubly_linked_list(root.right);
		//let Node root be a form of doubly linked list
		root.left = root.right = root;
		Node result = concatenate_lists(list1, root);
		result = concatenate_lists(result, list2);
		
		return result;
	}
	
	private Node concatenate_lists(Node head1, Node head2) {
		if(head1 == null) return head2;
		if(head2 == null) return head1;
		//the tail of a doubly linked list is the head.left;
		Node tail1 = head1.left ;
		Node tail2 = head2.left;
		//make the 2 list linked together,
		tail1.right = head2;
		head2.left = tail1;
		//make the whole linked list head's left point to the tail,
		//and the tail's right point to the head, so close it as DLL.
		head1.left  = tail2;
		tail2.right = head1;
		return head1;
	}
	
	static void printDLL(Node head){
		if(head == null) return;
		ArrayList<Integer> dll = new ArrayList<Integer>();
		dll.add(head.key);
		Node temp = head.right;
		while(temp != head){
			dll.add(temp.key);
			temp = temp.right;
		}
		
		System.out.println(dll);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tr1 = new BinaryTree();
		tr1.root = new Node(100);
		tr1.root.left = new Node(50);
		tr1.root.left.left = new Node(25);
		tr1.root.left.right = new Node(75);
		tr1.root.left.right.left = new Node(60);
		tr1.root.right = new Node(200);
		ConvertBTtoDLL cbd = new ConvertBTtoDLL();
		Node head = cbd.convert_to_doubly_linked_list(tr1.root);
		printDLL(head);

	}

}
