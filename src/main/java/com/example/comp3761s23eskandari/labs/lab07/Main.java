package com.example.comp3761s23eskandari.labs.lab07;

public class Main {

	public static void main(String[] args) {
		AdjGraph graph  = new AdjGraph(5);
		AdjGraph graph2 = new AdjGraph(4);
		AdjGraph graph3 = new AdjGraph(8);
		AdjGraph graph4 = new AdjGraph(4);

		//Graph 1
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		System.out.println(graph.toString());
		
		//Graph 1 Degrees
		System.out.println("Graph 1 Degrees:");
		System.out.println("degree[0]: " + graph.degree(0)); //degree of 3
		System.out.println("degree[2]: " + graph.degree(2)); //degree of 2
		System.out.println("degree[4]: " + graph.degree(4)); //degree of 3
		System.out.println("In degree of degree[0]: " + graph.inDegree(0));
		System.out.println("Out degree of degree[0]: " + graph.outDegree(0) + "\n");
		
		//Graph 2
		graph2.addEdge(0, 1);
		graph2.addEdge(1, 2);
		graph2.addEdge(2, 3);
		System.out.println(graph2.toString());
		//Graph 2 Degrees
		System.out.println("Graph 2 Degrees:");
		System.out.println("degree[0]: " + graph2.degree(0)); //degree of 1
		System.out.println("degree[2]: " + graph2.degree(2)); //degree of 2
		System.out.println("degree[3]: " + graph2.degree(3)); //degree of 1
		System.out.println("In degree of degree[3]: " + graph2.inDegree(3));
		System.out.println("Out degree of degree[3]: " + graph2.outDegree(3) + "\n");
		
		//Graph 3
		graph3.addEdge(0, 1);
		graph3.addEdge(0, 2);
		graph3.addEdge(0, 4);		
		graph3.addEdge(1, 3);
		graph3.addEdge(1, 5);		
		graph3.addEdge(2, 3);
		graph3.addEdge(2, 6);		
		graph3.addEdge(3, 7);
		graph3.addEdge(4, 5);
		graph3.addEdge(4, 6);		
		graph3.addEdge(5, 7);		
		graph3.addEdge(6, 7);		
		graph3.addEdge(7, 6);
		
		//Graph 4
		graph4.setDirected();
		graph4.addEdge(0, 2);
		graph4.addEdge(0, 3);
		graph4.addEdge(1, 3);
		System.out.println(graph4.toString());
		System.out.println("Graph 4 Directed: " + graph4.isDirected());
		System.out.println("degree[0]: " + graph4.degree(0));
		System.out.println("degree[2]: " + graph4.degree(2));
		System.out.println("In degree of degree[0]: " + graph4.inDegree(0));
		System.out.println("Out degree of degree[0]: " + graph4.outDegree(0) + "\n");
		
		System.out.println("Graph 3: \n");
		System.out.println("DFS: ");
		graph3.DFS(); //performs DFS on graph3
		
		System.out.println("\nBFS: ");
		graph3.BFS(); //performs BFS on graph3
		
		System.out.println("\nDFS Graph 4:");
		graph4.DFS();
		
		System.out.println("\nBFS Graph 4:");
		graph4.BFS();
		
		System.out.println("\nDFS Graph 1:");
		graph.DFS();
		
		System.out.println("\nBFS Graph 1:");
		graph.BFS();
	}
}
