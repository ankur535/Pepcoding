package dsalevel2.advancedds.graphs;

import java.io.*;
import java.util.*;

public class MinimumCostToConnectAllCitiesKruskal {
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

		int[][] arr = new int[edges][3];

		for (int i = 0; i < edges; i++) {
			String[] parts = br.readLine().split(" ");
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);
			int wt = Integer.parseInt(parts[2]);
			graph.get(v1).add(new Edge(v2, wt));
			graph.get(v2).add(new Edge(v1, wt));

			arr[i][0] = v1;
			arr[i][1] = v2;
			arr[i][2] = wt;
		}

		int minimumCost = Kruskal(arr, vtces);
		System.out.println(minimumCost);
	}

	public static int leader(int u) {

		if (par[u] == u)
			return u;

		int pu = leader(par[u]);

		return par[u] = pu;
	}

	public static void merge(int pu, int pv) {

		if (size[pu] < size[pv]) {
			par[pu] = pv;
			size[pv] += size[pu];
		} else {
			par[pv] = pu;
			size[pu] += size[pv];
		}

	}

	static int[] par;
	static int[] size;

	public static int Kruskal(int[][] edges, int V) {

		// Simple kruska or Union find

		Arrays.sort(edges, (int[] a, int[] b) -> {
			return a[2] - b[2];
		});

		par = new int[V];
		size = new int[V];

		for (int i = 0; i < V; i++) {
			par[i] = i;
			size[i] = 1;
		}

		int total_weight = 0;

		for (int[] edge : edges) {

			int u = edge[0];
			int v = edge[1];
			int w = edge[2];

			int pu = leader(u);
			int pv = leader(v);

			if (pu != pv) {
				merge(pu, pv);
				total_weight += w;
			}
		}

		return total_weight;
	}

}