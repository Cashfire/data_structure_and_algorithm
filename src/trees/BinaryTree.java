package trees;

public class BinaryTree {
	Node root;
	BinaryTree(int k){
		root = new Node(k);
	}
	BinaryTree(){
		root = null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Node{
	int key;
	Node left, right;
	Node(int k) {
		this.key = k;
		left = right = null;
	}
}