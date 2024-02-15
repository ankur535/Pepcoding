package dsalevel1.advancedds.graphs;

import java.io.*;
import java.util.*;

public class MinimumWireToConnectAllPcs {

	static class Edge {
		int src;
		int nbr;
		int wt;

		Edge(int src, int nbr, int wt) {
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
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
			int wt = Integer.parseInt(parts[2]);
			graph[v1].add(new Edge(v1, v2, wt));
			graph[v2].add(new Edge(v2, v1, wt));
		}

		int src = Integer.parseInt(br.readLine());
		// write your code here

		minimumWireToConnect(graph, src);

	}

	static class Pair {
		int node;
		int parent;
		int weight;

		public Pair(int node, int parent, int weight) {
			this.node = node;
			this.parent = parent;
			this.weight = weight;
		}
	}

	// Using prims algorithm with weighted measure instead of visited
	public static void minimumWireToConnect(ArrayList<Edge>[] graph, int src) {

		int V = graph.length;

		int[] dijk = new int[V];
		Arrays.fill(dijk, Integer.MAX_VALUE);

		PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> {
			return a.weight - b.weight;
		});

		pq.add(new Pair(src, -1, 0));

		while (pq.size() > 0) {

			Pair top = pq.remove();

			int node = top.node;
			int parent = top.parent;
			int weight = top.weight;

			if (weight >= dijk[node])
				continue;

			if (parent != -1) {
				System.out.println("[" + node + "-" + parent + "@" + weight + "]");
			}

			dijk[node] = weight;

			for (Edge e : graph[node]) {

				int nbr = e.nbr;
				int wt = e.wt;

				if (wt < dijk[nbr] && parent != nbr) {
					pq.add(new Pair(nbr, node, wt));
				}
			}
		}
	}
}