package DiGraph_A5;

import java.util.HashMap;

public class Node {

	long idNum;
	String label;
	HashMap<String, Edge> inEdge;
	HashMap<String, Edge> outEdge;
	boolean known;
	long distance;

	

    Node(long idNum, String Label) {
    	this.idNum = idNum;
    	this.label = Label;
    	this.inEdge = new HashMap<String, Edge>();
    	this.outEdge = new HashMap<String, Edge>();
    	this.distance = Long.MAX_VALUE;
    	this.known = false;
    }
    
   
    
    
    
}
