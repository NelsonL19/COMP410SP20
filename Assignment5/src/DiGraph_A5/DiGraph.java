package DiGraph_A5;

import java.util.Map.Entry;
import java.util.*;


public class DiGraph implements DiGraphInterface {

	HashMap<String, Node> nodes = new HashMap<String, Node>();
	HashSet<Long>idNums = new HashSet<Long>();
	HashSet<Long> edges = new HashSet<Long>();
	int nodeAmt = 0;
	int edgeAmt = 0;



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
		

			
		nodes.get(label).outEdge.forEach((k,v) -> {  
			Edge edgesTR = v;
			edges.remove(edgesTR.idNum);
			nodes.get(label).inEdge.remove(edgesTR.source.label);

		});
		
	
		
		nodes.get(label).inEdge.forEach((k,v) -> {  
			Edge edgesTR = v;
			edges.remove(edgesTR.idNum);
			nodes.get(label).outEdge.remove(edgesTR.source.label);
		});
		


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
	
		MinBinHeap pq = new MinBinHeap();

		Node start = nodes.get(label);
		start.distance = 0;

		pq.insert(new EntryPair(label, (int) start.distance));

		while (pq.size() > 0) {
			Node n = nodes.get(pq.getMin().value);
			long d = n.distance;

			pq.delMin();
			n.known = true;

			Iterator<Entry<String, Edge>> outEdge = n.outEdge.entrySet().iterator();

			while (outEdge.hasNext()) {
				Edge currEdge = outEdge.next().getValue();
				Node currNode = nodes.get(currEdge.destination.label);
				if (!currNode.known) {
					long path = d + currEdge.weight;
					if (path < currNode.distance) {
						currNode.distance = n.distance + currEdge.weight;
						pq.insert(new EntryPair(currNode.label, (int) currNode.distance));
					}
				}
			}

		}
		
		nodes.forEach((k,v) -> {  
			if (!v.known) {
				v.distance = -1;
			}
		});

		ShortestPathInfo[] shortestPath = new ShortestPathInfo[nodeAmt];

		Iterator<Entry<String, Node>> verticesValues = nodes.entrySet().iterator();

		for (int i = 0; verticesValues.hasNext(); i++) {
			Node vertVals = verticesValues.next().getValue();
			shortestPath[i] = new ShortestPathInfo(vertVals.label, vertVals.distance);
		}

		return shortestPath;
	}

}
