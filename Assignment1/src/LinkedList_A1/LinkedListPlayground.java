package LinkedList_A1;

public class LinkedListPlayground {

	public static void main(String[] args) { 
		/*
     here you can instantiate your LinkedList and play around with it to check
     correctness. We've graciously also provided you a bit of extra test data for debugging.
     It doesn't matter what you have in here. We will not grade it. This is for your use in testing your implementation.
		 */
		 test1();
		test2();
		test3();
		test4();
		test5();
		test6();
			test7();
		test8();
		test9();
		test10();
		test11();
	test12();



	}

	private static void test12() {
		LinkedListImpl L= new LinkedListImpl();
		System.out.println("Insort: " + L.insort(14));
		System.out.println("Insort: " + L.insort(21));
		System.out.println("Insort: " + L.insort(0));
		System.out.println("Insort: " + L.insort(1));
		System.out.println("Insort: " + L.insort(5));
		System.out.println("Insort: " + L.insort(9.9));
		System.out.println("Remove: " + L.remove(0));
		System.out.println("Remove: " + L.remove(0));
		System.out.println("Remove: " + L.remove(0));

		

		printList(L);
	}

	private static void test11() {
		LinkedListImpl L= new LinkedListImpl();	
		System.out.println("Insert: " + L.insert(4,0));
		System.out.println("Insert: " + L.insert(8,1));
		System.out.println("Remove: " + L.remove(0));
		printList(L);
	}

	private static void test10() {
		LinkedListImpl L= new LinkedListImpl();
		System.out.println("Insort: " + L.insort(14));
		System.out.println("Insort: " + L.insort(21));
		System.out.println("Insert: " + L.insert(10,1));
		System.out.println("Remove: " + L.remove(2));
		System.out.println("Insort: " + L.insort(8));
		System.out.println("Insert: " + L.insert(20,3));
		System.out.println("Insort: " + L.insort(17));
		System.out.println("Insort: " + L.insort(14));
		System.out.println("8,14,10,14,17,20");
		printList(L);


	}

	private static void test9() {
		//Insort Test 0: insort(14),insort(21),insort(5),insort(17),insort(67) --> 5,14,17,21,67
		//Insort Test 1: insort(10),insort(15),insort(15),insort(20),insort(15),insort(10) --> 10,10,15,15,15,20
		LinkedListImpl L= new LinkedListImpl();
		System.out.println("Insort: " + L.insort(14));
		System.out.println("Insort: " + L.insort(21));
		System.out.println("Insort: " + L.insort(5));
		System.out.println("Insort: " + L.insort(17));
		System.out.println("Insort: " + L.insort(67));
		System.out.println("5,14,17,21,67");
		printList(L);


		LinkedListImpl A= new LinkedListImpl();
		System.out.println("Insort: " + A.insort(10));
		System.out.println("Insort: " + A.insort(15));
		System.out.println("Insort: " + A.insort(15));
		System.out.println("Insort: " + A.insort(20));
		System.out.println("Insort: " + A.insort(15));
		System.out.println("Insort: " + A.insort(10));
		System.out.println("10,10,15,15,15,20");
		printList(A);

	}

	private static void test8() {
		LinkedListImpl L= new LinkedListImpl();
		System.out.println("Insert: " + L.insert(3,0));
		System.out.println("Insert: " + L.insert(5,1));
		System.out.println("Insert: " + L.insert(6,2));
		System.out.println("Insert: " + L.insert(4,1));
		System.out.println("Remove: " + L.remove(3));
		System.out.println("3 < 4 < 5");
		printList(L);


		LinkedListImpl A= new LinkedListImpl();
		System.out.println("Insert: " + A.insert(3,0));
		System.out.println("Insert: " + A.insert(5,1));
		System.out.println("Insert: " + A.insert(6,2));
		System.out.println("Insert: " + A.insert(4,1));
		System.out.println("Remove: " + A.remove(2));
		System.out.println("3 > 4 > 6");
		printList(A);


	}

	private static void test7() {
		LinkedListImpl L= new LinkedListImpl();
		System.out.println("Insert: " + L.insert(3,0));
		L.clear();
		System.out.println("Cleared");
		System.out.println("Insert: " + L.insert(5,0));
		System.out.println("Insert: " + L.insert(6,1));
		System.out.println("Insert: " + L.insert(4,0));
		printList(L);


	}

	private static void test6() {
		LinkedListImpl L= new LinkedListImpl();
		System.out.println("Insert: " + L.insert(3,0));
		System.out.println("Insert: " + L.insert(5,1));
		System.out.println("Insert: " + L.insert(6,2));
		System.out.println("Insert: " + L.insert(4,1));
		printList(L);

	}

	private static void test5() {
		LinkedListImpl L= new LinkedListImpl();
		System.out.println("Insert: " + L.insert(3,0));
		System.out.println("Insert: " + L.insert(5,1));
		System.out.println("Got: " + L.get(0));

	}

	private static void test4() {
		LinkedListImpl L= new LinkedListImpl();
		System.out.println("Is Empty: " + L.isEmpty());
		printList(L);
		L.clear();
		System.out.println("Cleared");
		System.out.println("Size: " + L.size());
		System.out.println("Insert: " + L.insert(1,0));
		System.out.println("Insert: " + L.insert(4,1));
		System.out.println("Insert: " + L.insert(6,2));
		System.out.println("Insert: " + L.insert(10,2));


		System.out.println("Is Empty: " + L.isEmpty());
		System.out.println("Size: " + L.size());
		System.out.println("Remove: " + L.remove(1));
		printList(L);
		System.out.println("Is Empty: " + L.isEmpty());
	}

	public static void test3(){
		LinkedListImpl L= new LinkedListImpl();
		System.out.println("Is Empty: " + L.isEmpty());
		printList(L);
		L.clear();
		System.out.println("Cleared");
		System.out.println("Size: " + L.size());
		System.out.println("Insert: " + L.insert(1,0));
		//System.out.println("Is Empty: " + L.isEmpty());
		//System.out.println("Size: " + L.size());
		System.out.println("Insert: " + L.insert(4,1));
		System.out.println("Insert: " + L.insert(2,0));
		//System.out.println("Size: " + L.size());
		printList(L);
		System.out.println("Get at 0: " + L.get(0));
		System.out.println("Get at 1: " + L.get(1));
		L.clear();
		System.out.println("Cleared");
		System.out.println("Is Empty: " + L.isEmpty());
		System.out.println("Size: " + L.size());
	}

	public static void test1(){
		// example test cases
		LinkedListImpl L= new LinkedListImpl();
		System.out.println(L.isEmpty());
		printList(L);
		L.clear();
		System.out.println(L.isEmpty());
		printList(L);
		L.insert(3.3,0);
		System.out.println(L.isEmpty());
		printList(L);
		L.insert(3.4, 0);
		L.insert(3.5, 0);
		L.insert(3.67, 1);
		L.insert(3.357, 0);
		L.insert(3.333, 4);
		System.out.println(L.size());
		printList(L);
		L.remove(3);
		System.out.println(L.size());
		printList(L);
		L.clear();
		L.insert(3.4, 0);
		L.insert(3.5, 0);
		L.insert(3.67, 1);
		L.insert(3.357, 0);
		L.insert(3.333, 3);
		L.remove(0);
		System.out.println(L.size());
		printList(L);
		System.out.println("Test 1 Done");
	}

	public static void test2(){
		// example test cases
		LinkedListImpl L= new LinkedListImpl();
		L.insert(3.4,0);
		L.insert(3.5,1);
		L.insert(3.67,2);
		L.remove(0);
		System.out.println(L.size());
		printList(L);
	}

	public static void printList(LinkedListImpl L){ 
		//note that this is a good example of how to iterate through your linked list
		// since we know how many elements are in the list we can use a for loop
		Node curr=L.headCell; // the first data node in the list... might be null
		System.out.print("List: ");
		for(int i=0; i<L.size(); i++) { 
			System.out.print(" --> " + curr.data);
			curr=curr.next;
		}
		System.out.println();
	}
}