package graph;

import java.util.LinkedList;

public class Graph {
	private int V; // number of vertices in the graph (order)
	private int E; // number of edges in the graph
	private LinkedList<Integer> adj[]; // array of adjacency lists for each vertex (0 to V-1)
	
	public Graph(int V) {
		this.V = V;
		this.E = 0;
		this.adj = new LinkedList[V];
		
		for(int i = 0; i < V; i++) {
			this.adj[i] = new LinkedList<Integer>(); // initializing each array item with an empty list
		}
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	public Iterable<Integer> adjList(int v) {
		return adj[v];
	}
};