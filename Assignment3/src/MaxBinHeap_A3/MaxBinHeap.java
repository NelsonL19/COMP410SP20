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

		//if (size < 2) {

		//		if (size == 0) {
		//			array[1] = element;
		//			size++;
		//			return;
		//		}

		//Hard-Coded 0 and 1 for reminders
		//			if (size == 1) {
		//				if (array[1] > element) {
		//					array[2] = element; 
		//					size++;
		//					return;
		//				} else {
		//					double temp = array[1];
		//					array[1] = element;
		//					array[2] = temp;
		//					size++;
		//					return;
		//				}
		//			}	
		//		}
		//Rest of Non-Hard Coded Insert

		array[size+1] = element;
		size++;
		insertBubbleUp(size);
		return;
	}

	private void insertBubbleUp(double i) {
		if (i != 1) {
			if (array[(int) java.lang.Math.floor((i/2))] < array[(int) i]) {

				double parent = array[(int) java.lang.Math.floor((i/2))];
				array[(int) java.lang.Math.floor((i/2))] = array[(int) i];
				array[(int) i] = parent;

				insertBubbleUp(java.lang.Math.floor((i/2)));

			}
		}
	}


	public void delMax() {


		if (size == 1) {
			array[1] = Double.NaN;
			size = 0;
			return;
		}

		array[1] = array[size];
		array[size] = 0.0;
		bubbleDownNew(1, array[1]);
		size--;
	}


	private void bubbleDownNew(int index, double val) {
		double tempVal = 0;
		double lChildVal = array[(index*2)];
		double rChildVal = array[((index*2)+1)];
		
		if (lChildVal == 0.0 && rChildVal == 0.0) {
			return;
		}

		if (array[index] < lChildVal) {
			tempVal = array[index];
			array[index] = array[index*2];
			array[index*2] = tempVal;

			
			
		} else if (array[index] < rChildVal) {
			tempVal = array[index];
			array[index] = array[(index*2)+1];
			array[(index*2)+1] = tempVal;
		} 
		
		
		bubbleDownNew((index*2), array[(index*2)]);
		bubbleDownNew((index*2)+1, array[(index*2)+1]);			



	}

	public void bubbleDownImproved() {
		
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
	}


	public int size() {
		return size;
	}


	public void build(double[] elements) {

		if (size() != 0) {
			clear();
		}
		//Code

		for (int i = 0; i < elements.length; i++) {
			array[i+1] = elements[i];
		}
		size = elements.length;
		bubbleDownNew(1, array[1]);
	}

	@Override
	public double[] sort(double[] elements) {
		// TODO Auto-generated method stub
		return null;
	}

	// add your method implementations
}