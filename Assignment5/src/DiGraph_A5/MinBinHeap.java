package DiGraph_A5;

public class MinBinHeap {
	private EntryPair[] array; //load this array
	private int size;
	private static final int arraySize = 10000;

	public MinBinHeap() {
		this.array = new EntryPair[arraySize];
		array[0] = new EntryPair(null, -100000);
	}

	public void insert(EntryPair entry) {

		if (entry == null|| entry.priority < 0 || entry.value == null) {
			return;
		}

		array[size+1] = entry;
		size++;
		insertBubbleUp(size);
		return;
	}

	public void delMin() {
		if (size == 0) {
			return;
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

}




