package BST_A2;

public class BST implements BST_Interface {
  public BST_Node root;
  int size;
  
  public BST(){ size=0; root=null; }
  
  //used for testing, please leave as is
  public BST_Node getRoot(){ return root; }

public boolean insert(String s) {

	if (s == null) {
		return false;
	}

	if (size == 0 && root == null) {
		root = new BST_Node(s);
		size++;
		return true;
	}

	if (root.insertNode(s, root)) {
		size++;
		return true;
	}
	return false;
}

public boolean remove(String s) {
	if (s == null || size == 0 || root == null) {
		return false;
	}

	if (size == 1) {
		root = null;
		size--;
		return true;
	}

	if (root.removeNode(s, root)) {
		size--;
		return true;
	}
	return false;
}


public String findMin() {

	if (size == 0) {
		return null;
	}

	if (root.left == null) {
		return root.data;
	}
	
	return root.left.findMin().data;
}

public String findMax() {

	if (size == 0) {
		return null;
	}

	if (root.right == null) {
		return root.data;
	}
	
	return root.right.findMax().data;
}


public boolean empty() {
	return (size == 0);
}


public boolean contains(String s) {

	if (s == null) {
		return false;
	}

	return root.contains(s, root);
}


public int size() {
	return size;
}


public int height() {

	if (size == 0 || root == null) {
		return -1;
	}


	return root.getHeight(root);
}

  //--------------------------------------------------
  //
  // of course, fill in the methods implementations
  // for the interface
  //
  //--------------------------------------------------

}