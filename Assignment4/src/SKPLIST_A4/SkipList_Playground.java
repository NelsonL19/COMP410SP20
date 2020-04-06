package SKPLIST_A4;



public class SkipList_Playground {
	public static void main(String[] args) {
		test1();
	}

	//  private static void test2() {
	//    SkipList_Interface list = new SkipList(5);
	//    System.out.println("=== INSERT ===");
	//    for(double i = 0; i < 5; i ++) {
	//      list.insert(i);
	//      System.out.println(list);
	//    }
	//    System.out.println("=== REMOVE ===");
	//    for(double i = 4; i >= 0; i --) {
	//      if (list.remove(i)) {
	//        System.out.println(list);
	//      }
	//    }
	//    System.out.println("=== INSERT ===");
	//    for(double i = 0; i < 5; i ++) {
	//      list.insert(i);
	//      System.out.println(list);
	//    }
	//  }

	private static void test1() {
		SkipList_Interface list = new SkipList(8);
		System.out.println("=== INSERT ===");
		for(double i = 1; i < 4; i ++) {
			list.insert(i*2);
			System.out.println(list);
		}

		System.out.println("=== INSERT Negative ===");
		list.insert(-4.0);
		System.out.println(list);

		//    System.out.println("=== Clear Test ===");
		//    list.clear();
		//    System.out.println(list);
		//    
		//    System.out.println("=== INSERT Negative ===");
		//    list.insert(-4.0);
		//    System.out.println(list);
		//    
		System.out.println("=== CONTAINS ===");
		for(double i = -5; i < 15; i ++) {
			System.out.println(i + ": " + list.contains(i));
		}

		System.out.println("=== Find Min/Max ===");
		System.out.println( list.findMin());
		System.out.println(list.findMax());


		System.out.println("=== Level ===");
		System.out.println(list.level());
		//    System.out.println("=== REMOVE ===");
		//    for(double i = -5; i < 15; i +=2) {
		////      System.out.println(i + ": " + list.remove(i));
		//      if (list.remove(i)) {
		//        System.out.println(list);
		//      }
		//    }
		////    System.out.println(list);
		////    System.out.println("=== CONTAINS ===");
		////    for(double i = -5; i < 15; i ++) {
		////      System.out.println(i + ": " + list.contains(i));
		////    }
		//    System.out.println("=== INSERT ===");
		//    for(double i = 0; i < 10; i ++) {
		//      list.insert(i);
		//      System.out.println(list);
		//    }
		////    System.out.println(list);
	}
}