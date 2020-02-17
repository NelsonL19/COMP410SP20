package BST_A2;

public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;

	BST_Node(String data){ this.data=data; }

	// --- used for testing  ----------------------------------------------
	//
	// leave these 3 methods in, as is

	public String getData(){ return data; }
	public BST_Node getLeft(){ return left; }
	public BST_Node getRight(){ return right; }

	// --- end used for testing -------------------------------------------

	// --------------------------------------------------------------------

	public boolean insertNode(String s, BST_Node root) {

		if (s == null) {
			return false;
		}

		if (root.data.compareTo(s) < 0) { //right
			if (root.right == null) {
				root.right = new BST_Node(s);
				return true;
			}
			return insertNode(s, root.right);
		} else {

			if (root.data.compareTo(s) > 0) { //left

				if (root.left == null) {
					root.left = new BST_Node(s);
					return true;
				}
				return insertNode(s, root.left);
			} 
		}

		return false;
	}

	public boolean removeNode(String s, BST_Node root) {

		if (s == null || root == null) {
			return false;
		}

		if (s.compareTo(root.data) == 0) {
			return root.removeNode(s, this);
		}

		if (s.compareTo(root.data) > 0) {
			return root.left.removeNode(s, this);
		}

		if (s.compareTo(root.data) < 0) {
			return root.right.removeNode(s, this);
		}




		return false;
	}

	public BST_Node findMin() {
		
		if (this.left == null) {
			return this;
		} 
		
		return this.left.findMin();
	}

	public BST_Node findMax() {
		if (this.right == null) {
			return this;
		} 
		
		return this.right.findMax();
	}

	public boolean contains(String s, BST_Node root) {
		
		if (root.data.compareTo(s) < 0) { //right
			if (root.right == null) {
				root.right = new BST_Node(s);
				return true;
			}
			return insertNode(s, root.right);
		} else {



			if (root.data.compareTo(s) > 0) { //left

				if (root.left == null) {
					root.left = new BST_Node(s);
					return true;
				}
				return insertNode(s, root.left);
			} 
		}
		
		
		
		return false;
	}

	public int getHeight(BST_Node root) {

		if (root == null) {
			return -1; 
		}


		int lBranch = getHeight(root.left);
		int rBranch = getHeight(root.right);


		if (lBranch > rBranch) {
			return (lBranch + 1);
		}

		if (rBranch > lBranch) {
			return (rBranch + 1);
		}


		return (lBranch + 1);

	}




	// --------------------------------------------------------------------

	public String toString(){
		return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
				+",Right: "+((this.right!=null)?right.data:"null");
	}



}