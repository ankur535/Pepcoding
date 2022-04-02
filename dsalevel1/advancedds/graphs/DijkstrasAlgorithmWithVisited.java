package dsalevel1.advancedds.graphs;

import java.util.*;

public class DijkstrasAlgorithmWithVisited {

	public static class Edge {
		int nbr;
		int wt;

		public Edge(int nbr, int wt) {
			this.nbr = nbr;
			this.wt = wt;
		}
	}

	public static class Pair {
		int node;
		int wsf;

		public Pair(int node, int wsf) {
			this.node = node;
			this.wsf = wsf;
		}
	}

	public static int[] dijkstra(ArrayList<Edge>[] graph, int src) {

		int V = graph.length;

		int[] ans = new int[V];
		boolean[] vis = new boolean[V];

		// sorting based on weight so far
		PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> {
			return a.wsf - b.wsf;
		});

		// initial src to src distance is 0
		pq.add(new Pair(src, 0));

		while (pq.size() > 0) {

			Pair top = pq.remove();

			int node = top.node;
			int wsf = top.wsf;

			// if already visited, continue
			if (vis[node])
				continue;

			// marking visited at removal time
			vis[node] = true;
			ans[node] = wsf;

			for (Edge e : graph[node]) {

				int nbr = e.nbr;
				int wt = e.wt;

				if (!vis[nbr]) {
					pq.add(new Pair(nbr, wsf + wt));
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {

	}

}
