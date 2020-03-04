package MaxBinHeap_A3;

public class MaxBinHeap implements Heap_Interface {
	private double[] array; //load this array
	private int size;
	private static final int arraySize = 10000; //Everything in the array will initially 
	//be null. This is ok! Just build out 
	//from array[1]

	public MaxBinHeap() {
		this.array = new double[arraySize];
		array[0] = Double.NaN;  //0th will be unused for simplicity 
		//of child/parent computations...
		//the book/animation page both do this.
	}

	//Please do not remove or modify this method! Used to test your entire Heap.
	@Override
	public double[] getHeap() { 
		return this.array;
	}


	public void insert(double element) {
		//If Element isn't valid, it returns
		if (element == Double.NaN) {
			return;
		}

		//Adds the Element to the end of the array, iterates size,
		//then bubbles up at that location
		array[size+1] = element;
		size++;
		insertBubbleUp(size);
		return;
	}

	private void insertBubbleUp(int index) {
		//creates an index for the parent of the current node
		int parentInd = parent(index);
		
		//If we aren't at the root:
		if (index != 1) {
			//If the parent is less than the current:
			if (array[parentInd] < array[index]) {
				
				//Swap the Parent and the Current
				double parent = array[parentInd];
				array[parentInd] = array[index];
				array[index] = parent;
				
				//Recursive Call
				insertBubbleUp(parentInd);

			}
		}
	}


	public void delMax() {
		//No Heap
		if (size == 0) {
			return;
		}
		//Heap of 1, set the array and size to 0. 
		if (size == 1) {
			array[1] = 0.0;
			size = 0;
			return;
		}
		//Move the last element to the first spot, then clear that former spot
		//Then bubble down from the first spot. 
		array[1] = array[size];
		array[size] = 0.0;
		bubbleDown(1, array[1]);
		size--;
	}





	private void bubbleDown(int index, double val) {
		//Invalid Bubble Location
		if (index > size) {
			return;
		}

		double tempVal = 0;
		double lChildVal = array[lChild(index)];
		double rChildVal = array[rChild(index)];

		//No Children to Bubble Down to
		if (lChildVal == 0.0 && rChildVal == 0.0) {
			return;
		}
		//If the array val  is less than the childs:
		if (val < lChildVal || val < rChildVal) {
			//Left first:
			if (lChildVal > rChildVal) {
				if (array[index] < lChildVal) {
					tempVal = array[index];
					array[index] = array[lChild(index)];
					array[lChild(index)] = tempVal;



				} else if (array[index] < rChildVal) {
					//Right Next:
					tempVal = array[index];
					array[index] = array[rChild(index)];
					array[rChild(index)] = tempVal;
				} 
			} 
			//Right First:
			if (rChildVal > lChildVal) {
				tempVal = array[index];
				array[index] = array[rChild(index)];
				array[rChild(index)] = tempVal;
			} 

		}
		
		//Recursive Call
		bubbleDown(lChild(index), array[lChild(index)]);
		bubbleDown(rChild(index), array[rChild(index)]);			



	}


	public double getMax() {
		//Invalid Heap
		if (size == 0 || array[1] == Double.NaN) {
			return Double.NaN;
		}
		//Return first element
		return array[1];
	}



	public void clear() {
		//Making a new array and setting 0th element to Double.NaN
		this.array = new double[arraySize];
		array[0] = Double.NaN;
		//New Size
		size = 0;
	}


	public int size() {
		return size;
	}


	public void build(double[] elements) {
		//Clear Heap
		if (size() != 0) {
			clear();
		}
		//Setting Array Elements into Array
		size = elements.length;
		for (int i = 1; i <= size; i++) {
			array[i] = elements[i-1];
		}
		//Cleaning/Bubbling the Tree
		bubbleDownBuild();
	}

	private void bubbleDownBuild() {
		
		int index = parent(size);
		
		//While not at root:
		while (index >= 1) {
			int currentIndex = index;
			//While Size is < current index
			while (size >= currentIndex) {
				
				//Checking Child of current Node
				if (array[lChild(currentIndex)] > array[currentIndex] || array[rChild(currentIndex)] > array[currentIndex]) {
					
					//If Child is Valid in Array
					if(rChild(currentIndex) > size || array[lChild(currentIndex)] > array[rChild(currentIndex)]) {
						double temp = array[currentIndex];
						array[currentIndex] = array[lChild(currentIndex)];
						array[lChild(currentIndex)] = temp;
						currentIndex = lChild(currentIndex);
						
						//If Right Child is > Left Child
					} else if (array[rChild(currentIndex)] > array[lChild(currentIndex)]) {

						double temp = array[currentIndex];
						array[currentIndex] = array[rChild(currentIndex)];
						array[rChild(currentIndex)] = temp;
						currentIndex = rChild(currentIndex);
					}
				} else {
					break;
				}

			}
			index--;
		}
	}



	public double[] sort(double[] elements) {
		
		//Invalid Input
		if (elements == null) {
			return null;
		}
		
		clear();
		build(elements);
		//New BinHeap
		
		double[] sortVals = new double[elements.length];
		//Getting the values into an exit array
		for (int i = 1; i <= elements.length; i++) {
			sortVals[elements.length-i] = getMax();
			delMax();
		}

		return sortVals;
	}


	//Helper Functions for Nodes/Locations
	public int parent(int i) {
		return (int) java.lang.Math.floor((i/2));

	}

	public int lChild(int i) {
		return (i*2);
	}


	public int rChild(int i) {
		return ((i*2)+1);
	}

	// add your method implementations
}