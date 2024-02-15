package dsalevel1.advancedds.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KruskalAlgorithm2 {

	public static class Edge {
		int src;
		int nbr;
		int wt;

		Edge(int src, int nbr, int wt) {
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}

	public static class Pair {
		int node;
		int parent;
		int weight;

		public Pair(int node, int parent, int weight) {
			this.node = node;
			this.parent = parent;
			this.weight = weight;
		}
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Edge>[] kruskal(int[][] edges, int V) {

		ArrayList<Edge>[] mst = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			mst[i] = new ArrayList<>();
		}

		Arrays.sort(edges, (int[] a, int[] b) -> {
			return a[2] - b[2];
		});

		int[] par = new int[V];
		for (int i = 0; i < V; i++) {
			par[i] = i;
		}

		for (int[] e : edges) {

			int node = e[0];
			int nbr = e[1];
			int wt = e[2];

			int parnode = findparent(node, par);
			int parnbr = findparent(nbr, par);

			if (parnode == parnbr)
				continue;

			mst[node].add(new Edge(node, nbr, wt));
			mst[nbr].add(new Edge(nbr, node, wt));

			par[parnbr] = parnode;
		}

		return mst;
	}

	private static int findparent(int u, int[] par) {

		while (u != par[u]) {
			u = par[u];
		}

		return u;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int vtces = Integer.parseInt(br.readLine());
		int edge = Integer.parseInt(br.readLine());

		int[][] edges = new int[edge][3];

		for (int i = 0; i < edge; i++) {
			String[] parts = br.readLine().split(" ");
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);
			int wt = Integer.parseInt(parts[2]);
			edges[i][0] = v1;
			edges[i][1] = v2;
			edges[i][2] = wt;
		}

		ArrayList<Edge>[] ans = kruskal(edges, vtces);
		for (ArrayList<Edge> al : ans) {
			for (Edge e : al) {
				System.out.print("(" + e.src + "," + e.nbr + "," + e.wt + ") , ");
			}
			System.out.println();
		}
	}
}
