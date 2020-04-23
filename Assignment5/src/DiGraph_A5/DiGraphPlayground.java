package DiGraph_A5;

public class DiGraphPlayground {

	public static void main (String[] args) {

		// thorough testing is your responsibility
		//
		// you may wish to create methods like 
		//    -- print
		//    -- sort
		//    -- random fill
		//    -- etc.
		// in order to convince yourself your code is producing
		// the correct behavior
		exTest();
		rmTest();
		spTest0();
		spTest1();
		spTest2();
		spTest3();
		spTest4();
		spTest5();
		efficiencyTest();
	}



	public static void efficiencyTest() {
		
		DiGraph d = new DiGraph();

		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < 1000000; i++) {
			d.addNode(i, "a"+i);
			d.addNode((i+1), "a"+(i+1));
			d.addEdge(i, ("a"+(int) i ), ("a"+(int)(i+1)), 2, null);
		}
		long endTime = System.currentTimeMillis();

		System.out.println("Time to add 1M Nodes: " + (endTime - startTime));

		long sTime = System.currentTimeMillis();

		
		ShortestPathInfo[] test	= d.shortestPath("a0");
		
		long eTime = System.currentTimeMillis();

		System.out.println("done. Time to do Dik of 1M Nodes: " + (eTime - sTime));
		
		for (int i = 0; i < d.nodeAmt; i++) {
			System.out.println(test[i]);
		}
		
	//	System.out.println(d.edges);
		
	}

	

	private static void rmTest() {
		DiGraph d = new DiGraph();
		d.addNode(0, "a");
		d.addNode(1, "b");
		d.addNode(2, "c");
		d.addNode(3, "d");
		d.addEdge(0, "a", "b", 1, null);
		System.out.println("numEdges: "+d.numEdges());
		System.out.println("numNodes: "+d.numNodes());
		System.out.println(d.edges);
		System.out.println(d.nodes.toString());
		d.delEdge("a", "b");
		System.out.println(d.edges);
		System.out.println(d.nodes.get("a").outEdge);
		System.out.println(d.nodes.get("b").inEdge);
		d.addEdge(0, "a", "b", 1, null);
		d.addEdge(1, "b", "a", 1, null);
		d.addEdge(2, "c", "d", 1, null);
		d.addEdge(3, "d", "c", 1, null);

		d.delNode("d");
		System.out.println(d.edges);

	}

	private static void spTest5() {
		System.out.println("test5");
		DiGraph d = new DiGraph();
		d.addNode(1, "a");
		d.addNode(2, "b");
		d.addNode(3, "c");
		d.addNode(4, "d");
		d.addNode(5, "e");
		
		d.addEdge(0, "a", "b", 1, null);
		d.addEdge(1, "a", "c", 3, null);
		d.addEdge(2, "a", "d", 5, null);
		d.addEdge(3, "a", "e", 9, null);
		
		d.addEdge(4, "b", "c", 1, null);
		d.addEdge(5, "b", "d", 2, null);
		d.addEdge(6, "b", "e", 7, null);
		
		d.addEdge(7, "c", "d", 2, null);
		d.addEdge(8, "c", "e", 5, null);

		d.addEdge(9, "d", "e", 3, null);
		
		ShortestPathInfo[] test = d.shortestPath("a");
		for (int i = 0; i < d.nodeAmt; i++) {
			System.out.println(test[i]);
		}
		
		
	}

	private static void spTest4() {
		System.out.println("test4");
		DiGraph d = new DiGraph();
		d.addNode(0, "0");
		d.addNode(1, "1");
		d.addNode(2, "2");
		d.addNode(3, "3");
		d.addNode(4, "4");
		d.addNode(5, "5");		
		d.addNode(6, "6");
		d.addEdge(0, "0", "5", 3, null);
		d.addEdge(1, "3", "2", 6, null);
		d.addEdge(2, "4", "0", 1, null);
		d.addEdge(3, "4", "5", 2, null);
		d.addEdge(4, "6", "2", 4, null);


		ShortestPathInfo[] test = d.shortestPath("0");
		for (int i = 0; i < d.nodeAmt; i++) {
			System.out.println(test[i]);
		}

	}

	private static void spTest3() {

		System.out.println("test3");
		DiGraph d = new DiGraph();
		d.addNode(1, "p");
		d.addNode(2, "a");
		d.addNode(3, "g");
		d.addNode(4, "e");
		d.addEdge(0, "p", "a", 10, null);
		d.addEdge(1, "p", "g", 4, null);
		d.addEdge(2, "a", "p", 9, null);
		d.addEdge(3, "a", "g", 12, null);
		d.addEdge(4, "a", "e", 100, null);
		d.addEdge(5, "g", "p", 2, null);
		d.addEdge(6, "g", "a", 15, null);
		d.addEdge(7, "g", "e", 1, null);
		d.addEdge(8, "e", "p", 6, null);
		d.addEdge(9, "e", "a", 3, null);




		ShortestPathInfo[] test = d.shortestPath("p");
		for (int i = 0; i < d.nodeAmt; i++) {
			System.out.println(test[i]);
		}

	}

	private static void spTest2() {
		System.out.println("test2");
		DiGraph d = new DiGraph();
		d.addNode(1, "a");
		d.addNode(2, "b");
		d.addNode(3, "c");
		d.addNode(4, "d");
		d.addEdge(0, "a", "b", 1, null);
		d.addEdge(1, "b", "c", 2, null);
		d.addEdge(2, "c", "a", 3, null);
		d.addEdge(3, "c", "d", 2, null);
		d.addEdge(4, "d", "b", 1, null);
		ShortestPathInfo[] test = d.shortestPath("a");
		for (int i = 0; i < d.nodeAmt; i++) {
			System.out.println(test[i]);
		}

	}

	private static void spTest1() {
		System.out.println("test1");
		DiGraph d = new DiGraph();
		d.addNode(1, "a");
		d.addNode(2, "b");
		d.addNode(3, "c");
		d.addEdge(0, "a", "b", 3, null);
		d.addEdge(1, "a", "c", 10, null);
		d.addEdge(2, "b", "c", 4, null);
		ShortestPathInfo[] test = d.shortestPath("a");
		for (int i = 0; i < d.nodeAmt; i++) {
			System.out.println(test[i]);
		}

	}

	public static void spTest0() {
		System.out.println("test0");
		DiGraph d = new DiGraph();
		d.addNode(1, "a");
		d.addNode(2, "b");
		d.addNode(3, "c");
		d.addEdge(0, "a", "b", 3, null);
		d.addEdge(1, "a", "c", 5, null);
		d.addEdge(2, "b", "c", 4, null);
		ShortestPathInfo[] test = d.shortestPath("a");
		for (int i = 0; i < d.nodeAmt; i++) {
			System.out.println(test[i]);
		}


	}

	public static void exTest(){
		DiGraph d = new DiGraph();
		d.addNode(1, "f");
		d.addNode(3, "s");
		d.addNode(7, "t");
		d.addNode(0, "fo");
		d.addNode(4, "fi");
		d.addNode(6, "si");
		d.addEdge(0, "f", "s", 0, null);
		d.addEdge(1, "f", "si", 0, null);
		d.addEdge(2, "s", "t", 4, null);
		d.addEdge(3, "fo", "fi", 0, null);
		d.addEdge(4, "fi", "si", 0, null);
		System.out.println("numEdges: "+d.numEdges());
		System.out.println("numNodes: "+d.numNodes());
		System.out.println(d.edges);
		System.out.println(d.nodes.toString());


	}
}