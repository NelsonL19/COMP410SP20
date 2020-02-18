package BST_A2;

public class BST_Playground {
	/*
	 * you will test your own BST implementation in here
	 *
	 * we will replace this with our own when grading, and will
	 * do what you should do in here... create BST objects,
	 * put data into them, take data out, look for values stored
	 * in it, checking size and height, and looking at the BST_Nodes
	 * to see if they are all linked up correctly for a BST
	 * 
	 */

	public static void main(String[]args){

		// you should test your BST implementation in here
		// it is up to you to test it thoroughly and make sure
		// the methods behave as requested above in the interface

		// do not simple depend on the oracle test we will give
		// use the oracle tests as a way of checking AFTER you have done
		// your own testing

		// one thing you might find useful for debugging is a print tree method
		// feel free to use the printLevelOrder method to verify your trees manually
		// or write one you like better
		// you may wish to print not only the node value, and indicators of what
		// nodes are the left and right subtree roots,
		// but also which node is the parent of the current node


		BST B = new BST();
		B.insert("Able");
		System.out.println(B.remove("Able"));
		System.out.println(B.remove("Aaa"));
		B.insert("Bravo");

		B.insert("Aaa");

		B.insert("Charlie");
		printLevelOrder(B);


		int i = 0;
		while (i < 2) {
			System.out.println("\n");
			i++;
		}
		i = 0;

		BST A = new BST();
		System.out.println("Insert: " + A.insert("Kris"));
		System.out.println("Insert: " + A.insert("Stot"));
		System.out.println("Insert: " + A.insert("Muns"));
		System.out.println("Insert: " + A.insert("Snoe"));
		System.out.println("Insert: " + A.insert("KMP"));

		printLevelOrder(A);

		//KMP
		//KRISJORDAN
		//Munsell
		//Snoeyoink
		//Stotts

		System.out.println("Height: " + A.height());
		System.out.println("Size: " + A.size);

		System.out.println("Remove: " + A.remove("Kris"));
		printLevelOrder(A);

		while (i < 2) {
			System.out.println("\n");
			i++;
		}
		i = 0;

		BST C = new BST();
		System.out.println("Insert: " + C.insert("6"));
		System.out.println("Insert: " + C.insert("2"));
		System.out.println("Insert: " + C.insert("8"));
		System.out.println("Insert: " + C.insert("1"));
		System.out.println("Insert: " + C.insert("5"));
		System.out.println("Insert: " + C.insert("3"));
		System.out.println("Insert: " + C.insert("4"));

		printLevelOrder(C);

		System.out.println("Remove: " + C.remove("2"));
		printLevelOrder(C);

		while (i < 2) {
			System.out.println("\n");
			i++;
		}
		i = 0;

		BST D = new BST();
		System.out.println("Insert: " + D.insert("6"));
		System.out.println("Insert: " + D.insert("2"));
		System.out.println("Insert: " + D.insert("8"));
		System.out.println("Insert: " + D.insert("1"));
		//System.out.println("Insert: " + D.insert("5"));
		System.out.println("Insert: " + D.insert("4"));
		System.out.println("Insert: " + D.insert("3"));

		printLevelOrder(D);

		System.out.println("Remove 4: " + D.remove("4"));
		printLevelOrder(D);
		
		while (i < 2) {
			System.out.println("\n");
			i++;
		}
		i = 0;
		
		BST E = new BST();
		System.out.println("Insert: " + E.insert("1"));
		System.out.println("Insert: " + E.insert("2"));
		System.out.println("Insert: " + E.insert("3"));
		//System.out.println("Insert: " + E.insert("4"));
		System.out.println("Insert: " + E.insert("5"));
		System.out.println("Insert: " + E.insert("6"));
		System.out.println("Insert: " + E.insert("7"));
		//System.out.println("Insert: " + E.insert("8"));
		System.out.println("Insert: " + E.insert("9"));

		printLevelOrder(E);
		System.out.println("Size: " + E.size);
		System.out.println("Height: " + E.height());

		

	}

	static void printLevelOrder(BST tree){ 
		//will print your current tree in Level-Order...
		//https://en.wikipedia.org/wiki/Tree_traversal
		int h=tree.height();
		for(int i=0;i<=h;i++){
			System.out.println("Level: " + i);
			printGivenLevel(tree.getRoot(), i);
			System.out.println("\n");
		}

	}
	static void printGivenLevel(BST_Node root,int level){
		if(root==null)return;
		if(level==0)System.out.print(root.data+" ");
		else if(level>0){
			printGivenLevel(root.left,level-1);
			printGivenLevel(root.right,level-1);
		}
	}
	static void printInOrder(BST_Node root){
		//will print your current tree In-Order
		if(root!=null){
			printInOrder(root.getLeft());
			System.out.print(root.getData() + " ");
			printInOrder(root.getRight());
		}
	}
}