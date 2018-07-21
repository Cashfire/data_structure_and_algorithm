/*
 * Given a binary tree, figure out whether it's a BST.
 * A BST holds the property that L < N < R.
 */
package trees;

import java.util.Stack;

public class IsBST {
	boolean inorder_way(Node root){
		Stack<Node> stk = new Stack<>();
		Node min = null;
		while(root != null || !stk.isEmpty()){
			//if root is not NULL, push and jump to the next while loop.
			if(root != null){
				stk.push(root);
				root = root.left;
				continue;
			}
			//L< N < R, so check before pop() that: N must > L.
			if(min != null && stk.peek().key <= min.key ){
				return false;
			}
			min = stk.pop();		
			root = min.right;	
		}
		return true;		
	}
	
	boolean recursion_way(Node root){
		return recursion_way(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	private boolean recursion_way(Node n, int minValue, int maxValue) {
		// TODO Auto-generated method stub
		if(n == null){
			return true;
		}
		if(n.key < minValue || n.key > maxValue){
			return false;
		}
		
		return recursion_way(n.left, minValue, n.key)&& recursion_way(n.right, n.key, maxValue);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tr1 = new BinaryTree();
		tr1.root = new Node(100);
		tr1.root.left = new Node(50);
		tr1.root.left.left = new Node(25);
		tr1.root.left.right = new Node(75);
		tr1.root.left.right.left = new Node(60);
		tr1.root.left.right.right = new Node (80);
		tr1.root.right = new Node(200);
		tr1.root.right.right = new Node(350);
		IsBST is = new IsBST();
		System.out.println(is.inorder_way(tr1.root));
		System.out.println(is.recursion_way(tr1.root));
	}

}
