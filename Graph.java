package GoogleInterviewPrep;

import java.util.LinkedList;

import GoogleInterviewPrep.GitSetupTest.GraphInterface;

public class Graph implements GraphInterface{
	
	
	public static void main(String[] args) {
		Graph G = new Graph(10);
		
		int[] l = new int[1];
		l[0] = 0;
		
		G.insert(new int[0]);
		G.insert(l);
		G.insert(l);
		G.insert(l);
		G.insert(l);
		G.insert(l);
		G.insert(l);
		G.insert(l);
		G.insert(l);
		System.out.println(G.nodeList[0].nodeChildren);
		
		
	}
	
	Node[] nodeList;
	int maxNodesInGraph;
	int maxNodeInserted = -1;
	
	Graph(int maxNodesInGraph){
		this.maxNodesInGraph = maxNodesInGraph;
		this.nodeList = new Node[maxNodesInGraph];
	}
	
	
	
	class Node{
		
		LinkedList<Node> nodeChildren = new LinkedList<>();
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


	

	public boolean connected(int a, int b) {
		
		Node nodeA = nodeList[a];
		Node nodeB = nodeList[b];
		
		return DFS(nodeA,nodeB);
	}
	
	
	private boolean DFS(Node root, Node targetNode)
	{
		if (root == null)
		{
			return false;
		} else if (root == targetNode) {
			return true;
		} else {
			for (Node child: root.nodeChildren){
				if (DFS(child, targetNode))
				{
					return true;
				}
			}
			return false;
		}
	}
}
