/*
 * Given the root node of a binary tree, print nodes forming the boundary (perimeter).
 * First, Print the root node.
 * Second, Print the left boundary in top-down order.
 * Third, Print the leaf nodes in left-right order.
 * Finally, Print the right boundary in bottom-up order.
 * TC: O(n); 
 * SC: O(h), which will be O(logn) for balanced tree and in worst case can be O(n).
 */
package trees;

public class PrintPerimeter {
	/* 
	 * output: 50, 70
	 */
    public static void print_left_perimeter(Node root) {
        while (root != null) {
          int curr_val = root.key;
          //if root has left child, 
          if (root.left != null) {
            root = root.left;
          } //if root doesn't have left child, but has the right child.
          else if(root.right != null) {
          root = root.right;
          }//if the root neither have left nor right,
           //which means the root is a leaf node.
          else {
              break; 
            }
            System.out.print(curr_val + " ");
          }       
    }
    
    /*
     * output: 60, 80, 300.
     */
    public static void print_leaf_nodes(Node root){
    	//leaf nodes are nodes that neither have left nor right child.
    	//if root == null, do nothing.
    	if(root != null){
    		print_leaf_nodes(root.left);
    		print_leaf_nodes(root.right);
  		
    		if(root.left == null && root.right == null){
        		System.out.print(root.key+ ", ");
        	}
    	} 	
    }
    
    public static void print_right_perimeter(Node root){
    	while(root!= null){
    		int curr_val = root.key;
    		if(root.right != null){
    			root = root.right;
    		}else if(root.left != null){
    			root = root.right;
    		}else{
    			break;
    		}
    		System.out.print(curr_val+ ", ");
    	}
    }
    
	public static void display_perimeter(Node root){
		if(root != null){
			System.out.println(root.key);
			
			print_left_perimeter(root.left);
			System.out.println();
			if(root.left != null && root.right != null){
				//no need to print if root is also the leaf node.
				print_leaf_nodes(root);
			}
			System.out.println();
			print_right_perimeter(root.right);
		}
	}
    public static void main(String[] args) {
		BinaryTree tr1 = new BinaryTree();
		tr1.root = new Node(100);
		tr1.root.left = new Node(50);
		tr1.root.left.right = new Node(70);
		tr1.root.left.right.left = new Node(60);
		tr1.root.left.right.right = new Node(80);
		tr1.root.right = new Node(200);
		tr1.root.right.right = new Node(300);
		display_perimeter(tr1.root);
		
	}

}
