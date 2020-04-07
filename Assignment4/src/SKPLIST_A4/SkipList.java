package SKPLIST_A4;

import java.util.Arrays;
import java.util.Random;

public class SkipList implements SkipList_Interface {
	private SkipList_Node root;
	private final Random rand;
	private double probability;
	private final int MAXHEIGHT = 30; // the most links that a data cell may contain
	private int MaxHeight;
	public int size = 0;

	public SkipList(int maxHeight) {
		if (maxHeight > MAXHEIGHT) {
			maxHeight = MAXHEIGHT;
		}
		root = new SkipList_Node(Double.NaN, maxHeight);
		rand = new Random();
		probability = 0.5;
		MaxHeight = maxHeight;
	}

	@Override
	public void setSeed(long seed) { rand.setSeed(seed); }

	@Override
	public void setProbability(double probability) { 
		this.probability = probability; 
	}

	private boolean flip() {
		// use this where you "roll the dice"
		// call it repeatedly until you determine the level
		// for a new node
		return rand.nextDouble() < probability;
	}

	@Override
	public SkipList_Node getRoot() { return root; }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		int levels;
		for(levels = 0; levels < root.getNext().length && root.getNext(levels) != null; levels ++);

		StringBuilder[] sbs = new StringBuilder[levels];

		for(int i = 0; i < sbs.length; i ++) {
			sbs[i] = new StringBuilder();
			sbs[i].append("level ").append(i).append(":");
		}

		SkipList_Node cur = root;

		while (cur.getNext(0) != null) {
			cur = cur.getNext(0);
			for(int i = levels - 1; i >= cur.getNext().length; i --) {
				sbs[i].append("\t");
			}
			for(int i = cur.getNext().length - 1; i >= 0; i --) {
				if (cur.getNext(i) == null) {
					levels --;
				}
				sbs[i].append("\t").append(cur.getValue());
			}
		}

		for(int i = sbs.length - 1; i >= 0; i --) {
			sb.append(sbs[i]).append("\n");
		}

		return sb.toString();
	}


	public boolean insert(double value) {
		//Already Exists
		if (contains(value) || value == Double.NaN) {
			return false;
		}

		//size++;
		int insertHeight = 1;
		//Creation Data that we need

		//Setting Node Height
		while (flip() && insertHeight < MaxHeight && insertHeight < 30) {
			if (insertHeight >= MaxHeight) {
				break;
			}
			insertHeight++;
		}

		SkipList_Node toAdd = new SkipList_Node(value, insertHeight);


		//Base Case
		//		if (size == 0) {
		//			for (int i = 0; i < insertHeight; i++) {
		//				root.setNext(i, toAdd);
		//			}
		//			size++;
		//			return true;
		//		}


		for (int i = insertHeight-1; i > -1; i--) {

			if (root.getNext(i) == null) {
				toAdd.setNext(i, root.getNext(i)); //This seems optional (covers only the base case)
				root.setNext(i, toAdd);
			} else if (root.getNext(i).getValue() > value) {
				toAdd.setNext(i, root.getNext(i));
				root.setNext(i, toAdd);
			} else {
				SkipList_Node currRoot = root;
				while (currRoot.getNext(i).getValue() < value && currRoot.getNext(i) != null) {
					currRoot = currRoot.getNext(i);
					if (currRoot.getNext(i) == null) {
						break;
					}
				}
				toAdd.setNext(i, currRoot.getNext(i));
				currRoot.setNext(i, toAdd);
			}



		}
		size++;
		return true;
	}


	public boolean remove(double value) {
		if (!contains(value) || size == 0) {
			return false;
		}
		
		int currHeight = MaxHeight-1;
	

		while (currHeight > -1) {
			SkipList_Node curr = root;
			for (int i = 0; i <= size; i++) {
				if (curr.getNext(currHeight) != null &&
						curr.getNext(currHeight).getValue() == value ) {
					curr.setNext(currHeight, curr.getNext(currHeight).getNext(currHeight));
				}

				
				if (curr.getNext(currHeight) == null || 
						curr.getNext(currHeight).getValue() > value) {
					break;
				}

				curr = curr.getNext(currHeight);
			}
			currHeight--;
		}

		size--;
		return true;
	}

//	public boolean removeRecursive(double value, int currHeight) {
//		//Move down a layer
//		if (currHeight != 0 && root.getNext(currHeight) == null) {
//			return removeRecursive(value, currHeight-1);
//		}
//
//		SkipList_Node toRemove = root;
//
//		while (toRemove.getNext(currHeight) != null) {
//			if (toRemove.getNext(currHeight).getValue() == value) {
//				SkipList_Node next = toRemove.getNext(currHeight).getNext(currHeight);
//				toRemove.setNext(currHeight, next);
//				if (currHeight == 0) {
//					return true;
//				}
//				return removeRecursive(value, currHeight-1);
//			}
//
//			//moving down a layer
//			toRemove = toRemove.getNext(currHeight);
//			if (toRemove.getNext(currHeight) == null && currHeight != 0) {
//				removeRecursive(value, currHeight-1);
//			}
//		}
//
//		return true;
//	}


	public boolean contains(double value) {

		if (value == Double.NaN || size == 0) {
			return false;
		}

		//Start at the highest height, going all the way down
		int currHeight = MaxHeight-1;
		while (currHeight > -1) {
			SkipList_Node curr = root;
			for (int i = 0; i <= size; i++) {
				if (curr.getValue() == value ) {
					return true;
				}

				if (curr.getNext(currHeight) == null || 
						curr.getNext(currHeight).getValue() > value) {
					break;
				}

				curr = curr.getNext(currHeight);
			}
			currHeight--;
		}

		//Level 0, all the way at the bottom (N time complex)

		//		SkipList_Node curr = root;
		//		for (int i = 0; i <= size; i++) {
		//			if (curr.getValue() == value ) {
		//				return true;
		//			}
		//			if (curr.getNext(0) == null) {
		//				break;
		//			}
		//			curr = curr.getNext(0);
		//		}

		return false;
	}


	public double findMin() {
		return root.getNext(0).getValue();
	}


	public double findMax() {

		SkipList_Node curr = root;
		for (int i = 0; i <= size; i++) {
			if (curr.getNext(0) == null) {
				break;
			}
			curr = curr.getNext(0);
		}

		return curr.getValue();
	}

	public boolean empty() {	
		return (size == 0);
	}


	public void clear() {
		size = 0;
		root = new SkipList_Node(Double.NaN, MaxHeight);
		probability = 0.5;
	}


	public int size() {
		return size;
	}


	public int level() {

		if (size == 0) {
			return -1;
		}

		int currHeight = MaxHeight-1;
		for (int i = 0; i < MaxHeight; i++) {
			if (root.getNext(i) == null) {
				currHeight--;
			}	
		}



		return currHeight;
	}

	//---------------------------------------------------------
	// student code follows
	// implement the methods of the interface
	//---------------------------------------------------------

}