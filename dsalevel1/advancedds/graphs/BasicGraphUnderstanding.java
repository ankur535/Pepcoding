package dsalevel1.advancedds.graphs;

import java.util.*;

public class BasicGraphUnderstanding {

	// Edge class with u node, v node and weight w between node u and v
	static class Edge {
		int u;
		int v;
		int w;

		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}

	// considering a undirected graph
	public static void addEdge(int u, int v, int w, ArrayList<Edge>[] graph) {

		graph[u].add(new Edge(u, v, w));
		graph[v].add(new Edge(v, u, w));
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(System.in);

		int vtces = in.nextInt();

		ArrayList<Edge>[] graph = new ArrayList[vtces];

		for (int i = 0; i < vtces; i++) {
			graph[i] = new ArrayList<>();
		}

		int edge_count = in.nextInt();

		for (int i = 0; i < edge_count; i++) {
			int u = in.nextInt();
			int v = in.nextInt();
			int w = in.nextInt();

			addEdge(u, v, w, graph);
		}

		in.close();
		// write your code here

		display(graph);

	}

	public static void display(ArrayList<Edge>[] graph) {
		for (int i = 0; i < graph.length; i++) {
			System.out.print(i + "-> ");
			for (Edge e : graph[i]) {
				System.out.print("{ " + e.u + ", " + e.v + ", " + e.w + "}" + ",");
			}

			System.out.println();
		}
	}

}