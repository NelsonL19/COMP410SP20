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

    if (s == null || root == null) {
      return false;
    }

    if (s.compareTo(root.data) > 0) { //left

      if (left == null) {
        left = new BST_Node(s);
            }
      return root.left.insertNode(s, this);
    }

    if (s.compareTo(root.data) < 0) { //right
      if (right == null) {
        right = new BST_Node(s);
            }
      return root.right.insertNode(s, this);
          }

    return false;
  }

  public boolean removeNode(String s, BST_Node root) {

    if (s == null || root == null) {
      return false;
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
    return null;
  }

  public BST_Node findMax() {
    return null;
  }

  public boolean contains(String s, BST_Node root) {
    return false;
  }

  public int getHeight(BST_Node root) {
    return 0;
  }

  // --------------------------------------------------------------------
  
  public String toString(){
    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
            +",Right: "+((this.right!=null)?right.data:"null");
  }



}