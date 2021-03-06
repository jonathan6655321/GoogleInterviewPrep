package GoogleInterviewPrep;

import java.util.LinkedList;
import java.util.Queue;

import GoogleInterviewPrep.GitSetupTest.GraphInterface;

public class Graph implements GraphInterface{
	
	
	public static void main(String[] args) {
		Graph G = new Graph(20);
		
		System.out.println(GitSetupTest.test1(G));
		
		
		
//		int[] l = new int[1];
//		l[0] = 0;
//		
//		G.insert(new int[0]);
//		G.insert(l);
//		G.insert(l);
//		G.insert(l);
//		G.insert(l);
//		G.insert(l);
//		G.insert(l);
//		G.insert(l);
//		G.insert(l);
//		System.out.println(G.nodeList[0].nodeChildren);
//		
//		
	}
	
	Node[] nodeList;
	int maxNodesInGraph;
	int maxNodeInserted = -1;
	
	Graph(int maxNodesInGraph){
		this.maxNodesInGraph = maxNodesInGraph;
		this.nodeList = new Node[maxNodesInGraph];
	}
	
	
	
	class Node{
		int nodeKey;
		public boolean marked = false;
		LinkedList<Node> nodeChildren = new LinkedList<>();
	}
	
	
	public void insert(int[] parentsOfNode){
		
		Node insertedNode = new Node();
		
		this.nodeList[maxNodeInserted+1] = insertedNode;
		maxNodeInserted++;
		insertedNode.nodeKey = maxNodeInserted;
		
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
		
//		return DFS(nodeA,nodeB);
		return BFS(nodeA,nodeB);
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
	
	private boolean BFS(Node root, Node targetNode)
	{
		Queue<Node> Q = new LinkedList<>();
		LinkedList<Node> unmarkThese = new LinkedList<>();
		boolean found = false;
		
		Q.add(root);
		Node deqNode; 
		
		while(!Q.isEmpty())
		{
			deqNode = Q.poll();
			unmarkThese.add(deqNode);
			if (deqNode == targetNode)
			{
				found = true;
				break;
			}
			
			for (Node n: deqNode.nodeChildren)
			{
				if (!n.marked)
				{
					n.marked = true;	
					Q.add(n);
				}
			}
		}
		
		
		// unmark them:
		while (!Q.isEmpty())
		{
			unmarkThese.add(Q.poll());
		}
		
		for (Node n: unmarkThese)
		{
			n.marked = false;
		}
		
		return found;
	}
}
