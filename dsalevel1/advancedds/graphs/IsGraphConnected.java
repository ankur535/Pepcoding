package dsalevel1.advancedds.graphs;

import java.io.*;
import java.util.*;

public class IsGraphConnected {
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

	@SuppressWarnings("unchecked")
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

		// write your code here

		boolean[] vis = new boolean[vtces];
		int count = 0;

		for (int src = 0; src < vtces; src++) {

			if (!vis[src]) {
				count++;

				//if count is more than 1, means more than 1 component
				if (count > 1)
					break;

				//fill vis array for vertexed from src vertex
				fillConnected(graph, src, vis);
			}
		}

		//if only 1 component, means connected else not connected
		if (count == 1) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}

	public static void fillConnected(ArrayList<Edge>[] graph, int src, boolean[] vis) {

		//as soon as we come, mark vis as true
		vis[src] = true;
		
		//simple travelling DFS like always
		for (Edge e : graph[src]) {

			int nbr = e.nbr;
			//if neighbour of src not visited, travel to that neighbour
			if (!vis[nbr]) {
				fillConnected(graph, nbr, vis);
			}
		}
	}

}