package dsalevel2.advancedds.graphs;

import java.io.*;
import java.util.*;

public class MinimumCostToConnectAllCitiesPrims {
	static class Edge implements Comparable<Edge> {
		int v;
		int wt;

		Edge(int nbr, int wt) {
			this.v = nbr;
			this.wt = wt;
		}

		@Override
		public int compareTo(Edge o) {
			return this.wt - o.wt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int vtces = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		for (int i = 0; i < vtces; i++) {
			graph.add(new ArrayList<>());
		}

		int edges = Integer.parseInt(br.readLine());
		for (int i = 0; i < edges; i++) {
			String[] parts = br.readLine().split(" ");
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);
			int wt = Integer.parseInt(parts[2]);
			graph.get(v1).add(new Edge(v2, wt));
			graph.get(v2).add(new Edge(v1, wt));
		}

		int minimumCost = Prims(graph, 0);
		System.out.println(minimumCost);
	}

	public static int Prims(ArrayList<ArrayList<Edge>> graph, int src) {

		// here we will not create MST, just simply calculate the total weight of the
		// MST

		int V = graph.size();

		PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> {
			return a[2] - b[2];
		});

		pq.add(new int[] { src, -1, 0 });

		boolean vis[] = new boolean[V];

		int total_weight = 0;

		while (pq.size() > 0) {

			int[] top = pq.remove();

			int u = top[0];
			//int v = top[1];
			int w = top[2];

			if (vis[u])
				continue;

			vis[u] = true;

			total_weight += w;

			// adding new neighbours in PQ
			for (Edge e : graph.get(u)) {

				int nbr = e.v;
				int wt = e.wt;

				if (!vis[nbr]) {
					pq.add(new int[] { nbr, u, wt });
				}
			}
		}

		return total_weight;
	}

}