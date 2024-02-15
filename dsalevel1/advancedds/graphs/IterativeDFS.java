package dsalevel1.advancedds.graphs;

import java.io.*;
import java.util.*;

public class IterativeDFS {

	static class Edge {
		int src;
		int nbr;

		Edge(int src, int nbr) {
			this.src = src;
			this.nbr = nbr;
		}
	}

	static class Pair {
		int node;
		String path;

		Pair(int node, String path) {
			this.node = node;
			this.path = path;
		}
	}

	public static void iterativeDFS(ArrayList<Edge>[] graph, int src) {

		int V = graph.length;

		boolean[] vis = new boolean[V];

		Stack<Pair> st = new Stack<>();
		st.push(new Pair(src, src + ""));

		while (st.size() > 0) {

			Pair top = st.pop();

			int node = top.node;
			String psf = top.path;

			if (vis[node])
				continue;

			vis[node] = true;
			System.out.println(node + "@" + psf);

			for (Edge e : graph[node]) {

				int nbr = e.nbr;
				if (!vis[nbr]) {
					st.push(new Pair(nbr, psf + nbr));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int vtces = Integer.parseInt(br.readLine());
		ArrayList<Edge>[] graph = new ArrayList[vtces];
		for (int i = 0; i < vtces; i++) {
			graph[i] = new ArrayList<>();
		}

		int edges = Integer.parseInt(br.readLine());
		for (int i = 0; i < edges; i++) {
			String[] parts = br.readLine().split(" ");
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);
			graph[v1].add(new Edge(v1, v2));
			graph[v2].add(new Edge(v2, v1));
		}

		int src = Integer.parseInt(br.readLine());
		// write your code here

		// This question is iterative DFS which can be done with a stack
		iterativeDFS(graph, src);

	}

}