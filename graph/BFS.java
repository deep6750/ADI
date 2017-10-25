package graph;

import java.util.LinkedList;

public class BFS {
	int s;
	private boolean marked[];
	
	public BFS(Graph G, int s) {
		this.s = s;
		this.marked = new boolean[G.V()];
		bfs(G, this.s);
	}
	
	private void bfs(Graph G, int v) {
		
		Queue<Integer> q = new Queue<Integer>();
		
		q.insert(v);
		
		while(q.hasItems()) {
			int w = q.delete(); 
			marked[w] = true;

			// Insert adjList[] of w into queue
			for(Integer x : G.adjList(w)) {
				if(!marked[x]) {
					q.insert(x);
				}
			}
		}
	}
	
	public boolean hasPathTo(int w) {
		return marked[w] == true;
	}
};

/* GENERIC QUEUE IMPLEMENTATION WITH LINKED LIST */
class Queue<T> {
	private LinkedList<T> list = new LinkedList<T>();

	public void insert(T item) {
		list.addLast(item);
	}	
	public T delete() {
		return list.poll();
	}
	public boolean hasItems() {
		return !list.isEmpty();
	}
	public int size() {
		return list.size();
	}
};