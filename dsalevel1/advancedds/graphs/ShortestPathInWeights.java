package dsalevel1.advancedds.graphs;

import java.io.*;
import java.util.*;

public class ShortestPathInWeights {
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

		printShortestPathInWeights(graph, src, vtces);

	}

	static class Pair {
		int node;
		int wt;
		String path;

		public Pair(int node, int wt, String path) {
			this.node = node;
			this.wt = wt;
			this.path = path;
		}
	}

	// This code utilises Dijkstra to find single source shortest path and print
	// path
	public static void printShortestPathInWeights(ArrayList<Edge>[] graph, int src, int vtces) {

		int d[] = new int[vtces];
		Arrays.fill(d, Integer.MAX_VALUE);

		PriorityQueue<Pair> pq = new PriorityQueue<Pair>((Pair a, Pair b) -> {
			return a.wt - b.wt;
		});

		pq.add(new Pair(src, 0, 0 + ""));

		while (pq.size() > 0) {

			Pair top = pq.remove();

			int node = top.node;
			int wsf = top.wt;
			String psf = top.path;

			if (wsf >= d[node])
				continue;

			d[node] = wsf;
			System.out.println(node + " vis " + psf + " @ " + wsf);

			for (Edge e : graph[node]) {

				int nbr = e.nbr;
				int w = e.wt;

				if (wsf + w < d[nbr]) {
					pq.add(new Pair(nbr, wsf + w, psf + nbr));
				}

			}

		}
	}

}