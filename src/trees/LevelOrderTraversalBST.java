/*
 * Given root of a binary tree, display node values at each level. 
 * Node values for all levels should be displayed on separate lines.
 * Hint: FIFO.
 * TC:O(n);
 * SC:
 */
package trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalBST {
	void print(Node root){
		Queue<Node> curr_level = new LinkedList<>();
		curr_level.add(root);
		Queue<Node> next_level = new LinkedList<>();
		
		while(!curr_level.isEmpty()){	
			 //dequeue the curr_level and add their children to the next_level
			 Node curr = curr_level.poll();
			 System.out.print(curr.key+ ", ");
			 
			 if(curr.left != null){
				 next_level.add(curr.left);
			 }
			 if(curr.right != null){
				 next_level.add(curr.right);
			 }
			 //after dequeue, swap the next_level to the curr_level.
			 //the loop ends when both of the next_level and curr_level are empty.
			 if(curr_level.isEmpty()){
				 System.out.println();
				 curr_level = new LinkedList<>(next_level);
				 next_level.clear();
				 
			 }
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
		tr1.root.left.right.right = new Node (80);
		tr1.root.right = new Node(200);
		tr1.root.right.right = new Node(350);
		LevelOrderTraversalBST lot = new LevelOrderTraversalBST();
		System.out.println("Level order traversal of the Binary Tree is: ");
		lot.print(tr1.root);
		
	}

}
