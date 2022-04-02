package dsalevel1.advancedds.graphs;

import java.io.*;
import java.util.*;

public class PerfectFriends {

	static class Edge {
		int src;
		int nbr;

		public Edge(int src, int nbr) {
			this.src = src;
			this.nbr = nbr;
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		ArrayList<Edge>[] graph = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}

		int k = Integer.parseInt(br.readLine());

		for (int i = 0; i < k; i++) {

			String[] a = br.readLine().split(" ");
			int u = Integer.parseInt(a[0]);
			int v = Integer.parseInt(a[1]);

			graph[u].add(new Edge(u, v));
			graph[v].add(new Edge(v, u));
		}

		boolean[] vis = new boolean[n];

		ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

		// get connected components filled in comps
		for (int i = 0; i < n; i++) {
			if (!vis[i]) {
				ArrayList<Integer> comp = new ArrayList<Integer>();
				getConnectedComponents(graph, i, vis, comp);
				comps.add(comp);
			}
		}

		int ans = 0;

		// multiply size of different connected components to form possible groups
		for (int i = 0; i < comps.size(); i++) {
			for (int j = i + 1; j < comps.size(); j++) {
				ans += comps.get(i).size() * comps.get(j).size();
			}
		}

		System.out.println(ans);

	}

	// Get Total connected components in an arraylist
	public static void getConnectedComponents(ArrayList<Edge>[] graph, int src, boolean[] vis,
			ArrayList<Integer> comp) {

		vis[src] = true;
		comp.add(src);

		for (Edge e : graph[src]) {
			int nbr = e.nbr;
			if (!vis[nbr]) {
				getConnectedComponents(graph, nbr, vis, comp);
			}
		}
	}

}