/*Given a binary tree, write an iterative algorithm to traverse the tree inorder. 
 * Hint: stack
 * TC: Linear O(n); SC: O(h),
 * memory complexity as it instantiates a stack that has to store information up to height of binary tree h. 
 * It will be O(logn) for balanced tree and in worst case, can be O(n).
 */
package trees;

import java.util.Stack;

public class IterativeInorderTraversal {
	
	void traverse(Node root){
		if(root == null){
			return;
		}
		Stack<Node> stk = new Stack<Node>();
		
		
		while(root != null || !stk.isEmpty()){
			if(root != null ){
				stk.push(root);
				root = root.left;
				//if it's true, push and re-assign the root, but do not print, 
				//then jump immediately to the next iteration of the while loop.
				continue; 
			}
			
			System.out.print(stk.peek().key + ", ");
			root = stk.pop().right;
		}
		
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
		
		IterativeInorderTraversal iit = new IterativeInorderTraversal();
		iit.traverse(tr1.root);
		
	}

}
