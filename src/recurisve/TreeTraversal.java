package recurisve;

public class TreeTraversal {
	public static void main(String[] args){
		Tree tr = new Tree();
		tr.root = new Node("aa");
		Node n1 = new Node("bb");
		Node n2 = new Node("cc");
		tr.root.left = n1;
		tr.root.right = n2;
		System.out.println("Pre-Order:");
		preOrder(tr.root);
		System.out.println("In-Order:");
		inOrder(tr.root);
		System.out.println("Post-Order:");
		postOrder(tr.root);
	}
	public static void preOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.println(root.name);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void inOrder(Node root){
		if(root == null){
			return;
		}
		inOrder(root.left);
		System.out.println(root.name);
		inOrder(root.right);
	}
	public static void postOrder(Node root){
		if(root == null){
			return;
		}
		inOrder(root.left);
		inOrder(root.right);
		System.out.println(root.name);
	}
	
}

class Node{
	public String name = "cpp";
	Node left = null;
	Node right = null;
	Node(String name) {
		this.name = name;
	};
}

class Tree{
	public Node root = null;
}
