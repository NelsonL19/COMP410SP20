package DiGraph_A5;

public class MinBinHeap {
	private EntryPair[] array; //load this array
	private int size;
	private static final int arraySize = 10000; //Everything in the array will initially 
	//be null. This is ok! Just build out 
	//from array[1]

	public MinBinHeap() {
		this.array = new EntryPair[arraySize];
		array[0] = new EntryPair(null, -100000); //0th will be unused for simplicity 
		//of child/parent computations...
		//the book/animation page both do this.
	}

	//Please do not remove or modify this method! Used to test your entire Heap.

	public EntryPair[] getHeap() { 
		return this.array;
	}


	public void insert(EntryPair entry) {

		if (entry == null) {
			throw new IllegalArgumentException("EntryPair inserted is null");
		}


		if (entry.priority < 0) {
			throw new IllegalArgumentException("Priority is less than 0");
		}

		if (entry.value == null) {
			throw new IllegalArgumentException("Value is null");
		}


		array[size+1] = entry;
		size++;
		insertBubbleUp(size);
		return;
	}



	public void delMin() {
		if (size == 0) {
			throw new IllegalArgumentException("Size is 0");
		}
		if (size == 1) {
			array[1] = null;
			size = 0;
			return;
		}
		
		array[1] = array[size];
		array[size] = null;
		bubbleDown(1);
		size--;


	}


	public EntryPair getMin() {

		if (size == 0) {
			return null;
		}

		if (array[1] == null) {
			return null;
		}
		return array[1];
	}


	public int size() {
		return size;
	}


	public void build(EntryPair[] entries) {

		if (size > 0) {
			array = new EntryPair[arraySize];
			size = 0;
		}

		if (entries.length > 10000 || entries.length == 0) {
			throw new IllegalArgumentException("Entries's Length is an invalid value");
		}

		for (int i = 0; i < entries.length; i++) {
			if (entries[i] == null) {
				throw new IllegalArgumentException("Entry at " + i + " is an invalid value");
			}

			if (entries[i].value == null) {
				throw new IllegalArgumentException("Value at " + i + " is an invalid value");
			}

			array[size+1] = entries[i];
			size++;
			bubbleUp();
		}


	}

	public void insertBubbleUp(int index) {
		//creates an index for the parent of the current node
		int parentInd = parent(index);

		//If we aren't at the root:
		if (index != 1) {
			//If the parent is greater than the current:
			
			
			
			
			
			if (array[parentInd].priority > array[index].priority) {

				//Swap the Parent and the Current
				EntryPair parent = array[parentInd];
				array[parentInd] = array[index];
				array[index] = parent;

				//Recursive Call
				insertBubbleUp(parentInd);

			}
		}
	}



	public void bubbleUp() {

		for (int i = (size / 2); i >= 1; i--) {

			EntryPair rChild = array[(i*2)+1];
			EntryPair lChild = array[(i*2)];
			EntryPair parent = array[i];

			if (array[(i*2)+1] != null) {

				if (lChild.priority > rChild.priority) {
					if (rChild.priority < parent.priority) {

						EntryPair temp = parent;

						array[i] = rChild;
						array[(i*2)+1] = temp;

					}
				}

				if (lChild.priority < rChild.priority) {
					if (lChild.priority < parent.priority) {

						EntryPair temp = parent;
						array[i] = lChild;
						array[(i*2)] = temp;
					}
				}


			} else {
				if (array[(i*2)] == null) {
					continue;
				}
			}

			if (lChild.priority < parent.priority) {

				EntryPair temp = parent;

				array[i] = lChild;
				array[(i*2)] = temp;

			}


		}


	}

	public void bubbleDown(int i) {

		while (true) {
			if (i > size) {
				return;
			}

			if (array[left(i)] == null && array[right(i)] == null) {
				break;
			} else if (array[left(i)] != null && array[right(i)] == null) {
				if (array[i].priority > array[left(i)].priority) {
					EntryPair temp = array[right(i)];
					array[left(i)] = array[i];
					array[i] = temp;
					break;
				} else {
					break;
				}
			} else {
				if (array[i].priority > array[left(i)].priority || array[i].priority > array[right(i)].priority) {
					if (array[left(i)].priority > array[right(i)].priority) {
						EntryPair temp = array[right(i)];
						array[right(i)] = array[i];
						array[i] = temp;
						i = right(i);
					} else {
						EntryPair temp = array[left(i)];
						array[left(i)] = array[i];
						array[i] = temp;
						i = left(i);
					}
				} else {
					break;
				}

			} 

		}


	}

	public int left(int i) {
		return i*2;
	}

	public int right(int i) {
		return (i*2)+1;
	}

	public int parent(int i) {
		return (int) Math.floor(((double)i)/2);

	}

	//Helper Functions for Nodes/Locations


	public int lChild(int i) {
		return (i*2);
	}


	public int rChild(int i) {
		return ((i*2)+1);
	}



}




