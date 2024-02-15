package dsalevel1.advancedds.graphs;

import java.io.*;
import java.util.*;

public class OrderOfCompilation {
	static class Edge {
		int src;
		int nbr;

		Edge(int src, int nbr) {
			this.src = src;
			this.nbr = nbr;
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
		}

		// write your code here

		// This question is called topological sort
		// It can be solved in 2 ways

		// 1. output of DFS in reverse order which we have done below
		// 2. Source removal method, which we are not doing

		ArrayList<Integer> al = new ArrayList<Integer>();

		boolean[] vis = new boolean[vtces];

		for (int i = 0; i < vtces; i++) {

			if (!vis[i]) {
				fillWithDFS(graph, i, vis, al);
			}

		}

		for (int i = al.size() - 1; i >= 0; i--) {
			System.out.println(al.get(i));
		}

	}

	public static void fillWithDFS(ArrayList<Edge>[] graph, int src, boolean[] vis, ArrayList<Integer> al) {

		vis[src] = true;

		for (Edge e : graph[src]) {

			int nbr = e.nbr;

			if (!vis[nbr]) {
				fillWithDFS(graph, nbr, vis, al);
			}
		}

		al.add(src);

	}

}