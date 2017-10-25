package graph;

import java.util.Stack;
import java.util.ArrayList;

public class DFS {
	int s;
	private boolean marked[];
	private int edgeVia[];
	
	public DFS(Graph G, int s) {
		this.s = s;
		this.marked = new boolean[G.V()];
		this.edgeVia = new int[G.V()];
		dfs(G, this.s);
	}
	
	private void dfs(Graph G, int v) {
		
		// mark the visited vertex
		marked[v] = true;
		
		// go through adjList[] of current vertex
		for(Integer w : G.adjList(v)) {
			if(!marked[w]) {
				dfs(G, w);
				edgeVia[w] = v;
			}
		}
	}
	
	public boolean hasPathTo(int w) {
		return marked[w] == true;
	}
	
	public Iterable<Integer> PathTo(int w) {
		if (!marked[w]) return null;
		
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		stack.push(w);
		while(stack.peek() != s) {
			stack.push(edgeVia[w]);
			w = edgeVia[w];
		}
		
		while (!stack.empty()) {
			list.add(stack.pop());
		}
		
		return list;
	}
};