package trees;

public class CheckTwoBinaryTreesAreIdentical {

	boolean are_identical(Node t1n, Node t2n){
		if(t1n == null && t2n == null) {
			return true;
			}
		
		if(t1n != null && t2n != null){
			return ((t1n.key == t2n.key)&&
					are_identical(t1n.left, t2n.left) &&
					are_identical(t1n.right, t2n.right));
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tr1 = new BinaryTree();
		tr1.root = new Node(100);
		tr1.root.left = new Node(50);
		tr1.root.left.left = new Node(25);
		tr1.root.right = new Node(200);
		tr1.root.right.left = new Node(125);
		tr1.root.right.right = new Node(350);
		
		BinaryTree tr2 = new BinaryTree();
		tr2.root = new Node(100);
		tr2.root.left = new Node(50);
		//tr2.root.left.left = new Node(25);
		tr2.root.right = new Node(200);
		tr2.root.right.left = new Node(125);
		tr2.root.right.right = new Node(350);
		
		CheckTwoBinaryTreesAreIdentical check = new CheckTwoBinaryTreesAreIdentical();
		
		System.out.print(check.are_identical(tr1.root, tr2.root));
	}

}
