package dsalevel1.advancedds.graphs;

import java.util.*;

public class DijkstrasAlgorithm {

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

		//fill array with + infinity
		int[] dijk = new int[V];
		Arrays.fill(dijk, Integer.MAX_VALUE);

		//sorting based on weight so far
		PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> {
			return a.wsf - b.wsf;
		});

		//initial src to src distance is 0
		pq.add(new Pair(src, 0));

		while (pq.size() > 0) {

			Pair top = pq.remove();

			int node = top.node;
			int wsf = top.wsf;

			//if array already have less weight, no need to put it's neighbour
			if (wsf > dijk[node])
				continue;

			//updating at removal time
			dijk[node] = wsf;

			for (Edge e : graph[node]) {
				int nbr = e.nbr;
				int wt = e.wt;

				//check for weight to reach neightbour from node and update if smaller
				if (wsf + wt < dijk[nbr]) {
					pq.add(new Pair(nbr, wsf + wt));
				}
			}
		}

		return dijk;

	}

	public static void main(String[] args) {

	}

}
