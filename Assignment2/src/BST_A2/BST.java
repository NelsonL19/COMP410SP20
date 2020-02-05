package BST_A2;

public class BST implements BST_Interface {
  public BST_Node root;
  int size;
  
  public BST(){ size=0; root=null; }
  
  //used for testing, please leave as is
  public BST_Node getRoot(){ return root; }

public boolean insert(String s) {

	size++;
	return false;
}

public boolean remove(String s) {

	size--;
	return false;
}

@Override
public String findMin() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String findMax() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean empty() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean contains(String s) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public int size() {
	return size;
}

@Override
public int height() {
	// TODO Auto-generated method stub
	return 0;
}

  //--------------------------------------------------
  //
  // of course, fill in the methods implementations
  // for the interface
  //
  //--------------------------------------------------

}