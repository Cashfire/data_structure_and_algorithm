/*We are given root node of a binary tree and we have to write an iterator that takes in this root 
 * and iterates through the nodes of binary tree in an inorder way. 
 * The expectation is to write two critical methods of any iterator: hasNext() and getNext(). 
 * TC: Linear O(n); SC: O(h),
 * memory complexity as it instantiates a stack that has to store information up to height of binary tree h. 
 * It will be O(logn) for balanced tree and in worst case, can be O(n).
 */
package trees;

import java.util.Stack;

public class InorderIterator {
	Stack<Node> stk = new Stack<Node>();
	
	//constructor function
	public InorderIterator(Node curr){
		while(curr != null){
			/* reach the left most Node of the curr Node,
			 * and curr will be NULL at the end
			 */
			stk.push(curr);
			curr = curr.left;
		}
	}
	
	public boolean hasNext(){
		return !stk.isEmpty();
	}
	
	public Node getNext(){
		if(stk.isEmpty()){
			return null;
		}
		//Pop the top Node
		Node bePoped = stk.pop();
		Node newTop = bePoped.right;
		//if bePoped doesn't have right child, newTop = null
		//then skip the while loop and just return the bePoped Node this time.
		while(newTop != null){
			stk.push(newTop);
			newTop = newTop.left;
		}
		return bePoped;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tr1 = new BinaryTree();
		tr1.root = new Node(100);
		tr1.root.left = new Node(50);
		tr1.root.left.left = new Node(25);
		tr1.root.left.right = new Node(75);
		tr1.root.left.left.left = new Node(12);
		tr1.root.left.left.right = new Node(35);
		tr1.root.left.right.right = new Node(60);
		tr1.root.right = new Node(200);
		tr1.root.right.left = new Node(125);
		tr1.root.right.right = new Node(350);
		
		InorderIterator ii = new InorderIterator(tr1.root);
		while(ii.hasNext()){
			System.out.print(ii.getNext().key+ ", ");
		}
		
	}

}
