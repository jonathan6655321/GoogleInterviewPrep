package GoogleInterviewPrep;

import java.util.LinkedList;

public class Graph {
	
	Node[] nodeList;
	int maxNodesInGraph;
	int maxNodeInserted;
	
	Graph(int maxNodesInGraph){
		this.maxNodesInGraph = maxNodesInGraph;
		this.nodeList = new Node[maxNodesInGraph];
	}
	
	
	
	class Node{
		
		LinkedList<Node> nodeChildren;
	}
	
	
	public void insert(int[] parentsOfNode){
		
		Node insertedNode = new Node();
		
		this.nodeList[maxNodeInserted+1] = insertedNode;
		maxNodeInserted++;
		
		for (int parentIndex: parentsOfNode)
		{
			if (parentIndex > maxNodeInserted || parentIndex < 0)
			{
				System.out.println("tried to do something really bad. Ido what is wrong with you?");
			}
			
			nodeList[parentIndex].nodeChildren.add(insertedNode);
		}
	}
}
