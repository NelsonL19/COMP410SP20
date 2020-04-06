package MaxBinHeap_A3;

public class MaxBinHeap_Playground {
	public static void main(String[] args) {
		// Add more tests as methods and call them here!!
		//TestBuild();
		//TestSort();


		Test1();
		Test2();
		Test3();
		Test4();


	}

	private static void Test4() {
		MaxBinHeap mbh = new MaxBinHeap();
		double[] arr = {5,4,3,2,1};
		arr = mbh.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}

	private static void Test3() {
		MaxBinHeap mbh = new MaxBinHeap();
		double[] arr = {1,4,2,8,5,7};
		mbh.build(arr);
		printArray(mbh.getHeap());  
	}

	private static void Test2() {
		MaxBinHeap mbh = new MaxBinHeap();
		mbh.insert(5);
		mbh.insert(4);
		mbh.insert(3);
		mbh.insert(2);
		mbh.insert(1);
		//printArray(mbh.getHeap());  
		mbh.delMax();
		printArray(mbh.getHeap());  
		mbh.delMax();
		printArray(mbh.getHeap());  

	}

	public static void Test1(){
		MaxBinHeap mbh = new MaxBinHeap();
		mbh.insert(1);
		mbh.insert(2);
		mbh.insert(3);
		mbh.insert(4);
		mbh.insert(5);
		printArray(mbh.getHeap());


		System.out.println(mbh.getMax());


		//		mbh.delMax();
		//		printArray(mbh.getHeap());  
	}

	public static void TestBuild() {
		// constructs a new maxbinheap, constructs an array of double,
		// passes it into build function. Then print collection and heap.
		MaxBinHeap mbh = new MaxBinHeap();
		double[] collection = new double[] { 3, 8, 2, 1, 7, 4, 6, 5 };
		mbh.build(collection);
		printHeapCollection(collection);
		printHeap(mbh.getHeap(), mbh.size());
	}

	public static void TestSort() {
		// constructs a new maxbinheap, constructs an array of double, passes
		// it into heapsort function. Then print collection and sorted array.

		MaxBinHeap mbh = new MaxBinHeap();
		double[] collection = new double[] { 3, 8, 2, 1, 7, 4, 6, 5 };
		double[] sorted = mbh.sort(collection);
		printSortCollection(collection);
		printHeap(mbh.getHeap(), mbh.size());
		printArray(sorted);
	}

	public static double[] charsToDoubles(char[] chars) {
		double[] ret = new double[chars.length];
		for (int i = 0; i < chars.length; i++) {
			ret[i] = charToInt(chars[i]);
		}
		return ret;
	}

	public static int charToInt(char c) {
		return c - 'a';
	}

	public static void printHeapCollection(double[] e) {
		// this will print the entirety of an array of doubles you will pass
		// to your build function.
		System.out.println("Printing Collection to pass in to build function:");
		for (int i = 0; i <  e.length; i++) {
			System.out.print(e[i] + "\t");
		}
		System.out.print("\n");
	}

	public static void printHeap(double[] e, int len) {
		// pass in mbh.getHeap(),mbh.size()... this method skips over unused 0th
		// index....
		System.out.println("Printing Heap");
		for (int i = 1; i < len + 1; i++) {
			System.out.print(e[i] + "\t");
		}
		System.out.print("\n");
	}

	public static void printSortCollection(double[] e) {
		// this will print the entirety of an array of doubles you will pass
		// to your build function.
		System.out.println("Printing Collection to pass in to heap sort function:");
		for (int i = 0; i < e.length; i++) {
			System.out.print(e[i] + "\t");
		}
		System.out.print("\n");
	}

	public static void printArray(double[] array) {
		System.out.println("Printing Array");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
		System.out.print("\n");
	}
}