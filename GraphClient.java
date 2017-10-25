import graph.*;

public class GraphClient {
	
	public static void main(String[] args) {
		
		Graph g = new Graph(6);
		
		g.addEdge(0, 2); //      1 -- 3 -- 5
		g.addEdge(1, 3); //      |
		g.addEdge(3, 5); //      4
		g.addEdge(1, 4); //                2 -- 0
		
		System.out.print("\nAdjList(1): ");
		for(int i : g.adjList(1))
			System.out.print(i + " ");
		
		DFS dfs = new DFS(g, 1);
		
		System.out.print("\n1.hasPathTo(3): " + dfs.hasPathTo(3) + "  1.hasPathTo(5): " + dfs.hasPathTo(5) + "  1.hasPathTo(2): " + dfs.hasPathTo(2));

		BFS bfs = new BFS(g, 1);
		
		System.out.print("\n1.hasPathTo(3): " + bfs.hasPathTo(3) + "  1.hasPathTo(5): " + bfs.hasPathTo(5) + "  1.hasPathTo(2): " + bfs.hasPathTo(2));

	}
}
