/*
 * Inorder successor of a node in binary Search Tree (BST) is the next node in inorder traversal. 
 * Write a method to find the inorder successor of a given value "k" in a BST.
 * Hint: determine the situations of whether the node k has right child or not, which 
 * TC: Logarithmic, O(logn); SC: Constant, O(1).
 */
package trees;

public class InorderSuccessorBST {
	Node successor(Node root, int k){
		if(root == null){
			return null;
		}
		
		Node successor = null;
		while(root != null){
			/*
			 * Step 1, loop down until the node whose key == k.
			 *    if k > root, go to the right child, no need to mark because the successor is always bigger than k itself.
			 *    if k < root, mark root as successor and go to left to see if there is a smaller parent.
			 */
			if(k > root.key){
				root = root.right;
			}else if(k < root.key){
				successor = root;
				root = root.left;
			}else{
				/* Step 2, when k = root.key, there are 3 situations:
				 * 1st, k has right child, then k.successor is the left most in the right child's subtree;
				 * 2nd, k doesn't have right child and the last node, so its successor is NULL.
				 * 3rd, k doesn't have right child and is not the last node, whose successor has been marked at step one.
				*/
				if(root.right != null){
					successor = smallestParent(root.right);
				}
				break;
			}
		}		
		return successor;	
	}
	
	private Node smallestParent(Node root) {
		// TODO Auto-generated method stub
		while(root.left != null){
			root = root.left;
		}
		return root;
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
		InorderSuccessorBST isb = new InorderSuccessorBST();
		int[] arr = {25, 50, 60, 75, 80, 100, 200, 350};
		for(int i : arr){
			Node n = isb.successor(tr1.root, i);
			if(n != null){
				System.out.println("Successor of " + i+" is " + n.key);
			}else{
				System.out.println("Successor of " + i+" is NULL");
			}
		}
	}

}
