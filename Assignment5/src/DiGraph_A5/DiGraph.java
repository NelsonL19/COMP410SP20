package DiGraph_A5;

import java.util.Map.Entry;
import java.util.*;


public class DiGraph implements DiGraphInterface {

	HashMap<String, Node> nodes = new HashMap<String, Node>();
	HashSet<Long>idNums = new HashSet<Long>();
	HashSet<Long> edges = new HashSet<Long>();
	int nodeAmt = 0;
	int edgeAmt = 0;
	int currNode = 1;



	public DiGraph () {	
		// default constructor
		// explicitly include this
		// we need to have the default constructor
		// if you then write others, this one will still be there
	}



	public boolean addNode(long idNum, String label) {

		if (idNum < 0  || label == null) {
			return false;
		}

		if (nodes.containsKey(label) == true || idNums.contains(idNum) == true) {
			return false;
		}


		nodes.put(label, new Node(idNum, label));
		idNums.add(idNum);
		nodeAmt++;
		return true;

	}




	public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {


		if (idNum < 0  || sLabel == null || dLabel == null) {
			return false;
		}


		if (edges.contains(idNum) == true) {
			return false;
		}

		if (nodes.containsKey(sLabel) == false || nodes.containsKey(dLabel) == false) {
			return false;
		}


		if (nodes.get(dLabel).inEdge.containsKey(sLabel) || nodes.get(sLabel).outEdge.containsKey(dLabel)) {
			return false;
		}


		if (weight < 1) {
			weight = 1;
		} 


		Edge toAdd = new Edge(idNum, nodes.get(sLabel), nodes.get(dLabel), weight);
		edges.add(idNum);
		nodes.get(dLabel).inEdge.put(sLabel, toAdd);
		nodes.get(sLabel).outEdge.put(dLabel, toAdd);
		edgeAmt++;
		return true;
	}


	public boolean delNode(String label) {

		if (label == null) {
			return false;
		}

		if (nodes.containsKey(label) == false) {
			return false;
		}


		if (nodes.get(label) == null) {
			return false;
		}

		if (nodeAmt == 0) {
			return false;
		}

		Iterator<Entry<String, Edge>> edgeOut = nodes.get(label).inEdge.entrySet().iterator();
		while (edgeOut.hasNext()) {
			Edge edgesTR = (Edge) edgeOut.next();
			edges.remove(edgesTR.idNum);
			nodes.get(label).outEdge.remove(edgesTR.source.label);

		}

		Iterator<Entry<String,Edge>> edgeIn = nodes.get(label).outEdge.entrySet().iterator();
		while (edgeIn.hasNext()) {
			Edge edgesTR = (Edge) edgeIn.next();
			edges.remove(edgesTR.idNum);
			nodes.get(label).inEdge.remove(edgesTR.source.label);

		}


		if (nodes.containsKey(label)) {
			idNums.remove(nodes.get(label).idNum);
			nodes.remove(label);
			nodeAmt--;
			return true;
		}

		return true;

	}


	public boolean delEdge(String sLabel, String dLabel) {

		if (sLabel == null || dLabel == null) {
			return false;
		}

		if (edgeAmt < 1) {
			return false;
		}

		if (nodes.get(sLabel) == null) {
			return false;
		}

		if (nodes.get(dLabel) == null) {
			return false; 
		}

		if (nodes.get(sLabel).outEdge.get(dLabel) == null ||
				nodes.get(dLabel).inEdge.get(sLabel) == null) {
			return false;
		}



		long edgeId = nodes.get(sLabel).outEdge.get(dLabel).idNum;
		nodes.get(sLabel).outEdge.remove(dLabel);
		nodes.get(dLabel).inEdge.remove(sLabel);
		edges.remove(edgeId);

		edgeAmt--;
		return true;

	}


	public long numNodes() {
		return nodeAmt;
	}


	public long numEdges() {
		return edgeAmt;
	}


	public ShortestPathInfo[] shortestPath(String label) {
		nodes.forEach((k,v) -> {  
			v.known = false;
			v.distance = Long.MAX_VALUE;
		});

		ShortestPathInfo[] shortestPath = new ShortestPathInfo[nodeAmt];
		PriorityQueue<Node> pq = new PriorityQueue<Node>(); 

		nodes.get(label).distance = 0;
		shortestPath[0] = new ShortestPathInfo(label, nodes.get(label).distance);
		
		
		pq.add(new Node(nodes.get(label).distance, label));
		while (!pq.isEmpty()) {
			Node n = pq.peek();
			long d = n.distance;
			pq.remove();


			if (!n.known) {
				n.known = true;

			}

		}



		return shortestPath;
	}

}
