package DiGraph_A5;

public class Edge {

	long idNum;
	Node source;
	Node destination;
	long weight;



	Edge(long idNum, Node source, 
			Node destination, long weight) {
		this.idNum = idNum;
		this.source = source;
		this.destination = destination;
		this.weight = weight;

	}

	
}
