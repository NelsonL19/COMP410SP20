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

		if (element == Double.NaN) {
			return;
		}

		array[size+1] = element;
		size++;
		insertBubbleUp(size);
		return;
	}

	private void insertBubbleUp(int index) {

		int parentInd = (int) java.lang.Math.floor((index/2));

		if (index != 1) {
			if (array[parentInd] < array[index]) {

				double parent = array[parentInd];
				array[parentInd] = array[index];
				array[index] = parent;

				insertBubbleUp(parentInd);

			}
		}
	}


	public void delMax() {
		if (size == 0) {
			return;
		}

		if (size == 1) {
			array[1] = 0.0;
			size = 0;
			return;
		}

		array[1] = array[size];
		array[size] = 0.0;
		bubbleDownNew(1, array[1]);
		size--;
	}





	private void bubbleDownNew(int index, double val) {

		if (index > size) {
			return;
		}

		double tempVal = 0;
		double lChildVal = array[(index*2)];
		double rChildVal = array[((index*2)+1)];

		if (lChildVal == 0.0 && rChildVal == 0.0) {
			return;
		}

		if (val < lChildVal || val < rChildVal) {
			if (lChildVal > rChildVal) {
				if (array[index] < lChildVal) {
					tempVal = array[index];
					array[index] = array[index*2];
					array[index*2] = tempVal;



				} else if (array[index] < rChildVal) {
					tempVal = array[index];
					array[index] = array[(index*2)+1];
					array[(index*2)+1] = tempVal;
				} 
			} 

			if (rChildVal > lChildVal) {
				tempVal = array[index];
				array[index] = array[(index*2)+1];
				array[(index*2)+1] = tempVal;
			} 

		}
		bubbleDownNew((index*2), array[(index*2)]);
		bubbleDownNew((index*2)+1, array[(index*2)+1]);			



	}


	public double getMax() {

		if (size == 0 || array[1] == Double.NaN) {
			return Double.NaN;
		}

		return array[1];
	}



	public void clear() {
		this.array = new double[arraySize];
		array[0] = Double.NaN;
		size = 0;
	}


	public int size() {
		return size;
	}


	public void build(double[] elements) {

		if (size() != 0) {
			clear();
		}
		//Code
		size = elements.length;
		for (int i = 1; i <= size; i++) {
			array[i] = elements[i-1];
		}
		bubbleDownBuild();

		//		for (int i = 1; i <= size; i++) {
		//
		//			bubbleDownNew(i, array[i]);
		//		}

		//		for (int i = 0; i < elements.length; i++) {
		//			array[i+1] = elements[i];
		//			size++;
		//		}
		//		bubbleDownNew((int) (java.lang.Math.floor(size/2)), array[(int)(java.lang.Math.floor(size/2))]);

	}

	private void bubbleDownBuild() {

		int index = parent(size);

		while (index >= 1) {
			int currentIndex = index;

			while (currentIndex <= size) {

				if (array[lChild(currentIndex)] > array[currentIndex] || array[rChild(currentIndex)] > array[currentIndex]) {

					if(rChild(currentIndex) > size || array[lChild(currentIndex)] > array[rChild(currentIndex)]) {
						double temp = array[currentIndex];
						array[currentIndex] = array[lChild(currentIndex)];
						array[lChild(currentIndex)] = temp;
						currentIndex = lChild(currentIndex);

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

		if (elements == null) {
			return null;
		}
		clear();
		build(elements);
		
		double[] sortVals = new double[elements.length];
		
		for (int i = 1; i <= elements.length; i++) {
			sortVals[elements.length-i] = getMax();
			delMax();
		}

		return sortVals;
	}



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