
/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
 */
package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
	Node headCell; //this will be the entry point to your linked list (the head)
	Node lastCell; // this is the Node at the end of the list... the starting place
	// if you wanted to traverse the list backwards
	
	int counter = 0;


	public LinkedListImpl(){//this constructor is needed for testing purposes. Please don't modify!
		headCell = null; //Note that the root's data is not a true part of your data set!
		lastCell = null;
	}

	//implement all methods in interface, and include the getRoot method we made for testing 
	// purposes. Feel free to implement private helper methods!

	// add the fields you need to add to make it work... like a 

	public Node getRoot(){ //leave this method as is, used by the grader to grab your linkedList easily.
		return headCell;
	}
	public Node getLast(){ //leave this method as is, used by the grader to grab your linkedList easily.
		return lastCell;
	}

	
	public boolean insert(double elt, int index) {
		
		if (index > size() || index < 0) {
			return false; 
		}
		
		if (counter == 0) {
			Node toAdd = new Node(elt);
			headCell = toAdd;
			lastCell = toAdd;
			headCell.next = lastCell;
			lastCell.prev = headCell;
			
			
			counter++;
			return true;
		}
		
		Node toAdd = new Node(elt);
		Node toFind = headCell.prev;
		for (int i = 0; i < index; i++) {
			toFind = toFind.next;
		}
		Node next = toFind.next;
		
		toFind.next = toAdd;
		toAdd.prev = toFind;
		toAdd.next = next;
		next.prev = toAdd;
				
		counter++;
		return true;
	}

	@Override
	public boolean insort(double elt) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean remove(int index) {
		
		if (index > size() || index < 0) {
			return false; 
		}
		
		if (size() == 1) {
			clear();
			return true;
		}
		
		Node toFind = headCell.prev;
		for (int i = 0; i < index; i++) {
			toFind = toFind.next;
		}
		Node next = toFind.next;
		
		
		
		
		
		counter--;
		return false;
	}

	
	public double get(int index) {
		
		if (headCell == null) {
			return Double.NaN;
		}
		
		if (index < 0 || index > size()) {
			return Double.NaN;
		}
		
		Node toGet = headCell;
		for (int i = 0; i < index; i++) {
			toGet = toGet.next;
		}
		
		return toGet.getData();
	}


	public int size() {
		return counter;
	}


	public boolean isEmpty() {
		if (headCell == null) {
			return true;
		} else {
			return false;
		}
	}

	
	public void clear() {
		headCell = null;
		lastCell= null;
		counter = 0;
		System.gc();
	}
}