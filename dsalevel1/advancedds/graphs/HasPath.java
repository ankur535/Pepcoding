package dsalevel1.advancedds.graphs;

import java.io.*;
import java.util.*;

public class HasPath {
	static class Edge {
		// source, neighbour and weight
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

		int src = Integer.parseInt(br.readLine());
		int dest = Integer.parseInt(br.readLine());

		// write your code here
		// visited Array
		boolean[] vis = new boolean[vtces];
		System.out.println(hasPath(src, dest, graph, vis));
	}

	public static boolean hasPath(int src, int dest, ArrayList<Edge>[] graph, boolean[] vis) {

		//once src become dest, return true
		if (src == dest) {
			return true;
		}		
		
		// making visited of src as true
		vis[src] = true;

		for (Edge e : graph[src]) {
			// taking neighbour of src
			int nbr = e.nbr;
			if (!vis[nbr]) {
				//calling hasPath for nbr to search if nbr can reach dest
				if (hasPath(nbr, dest, graph, vis)) {
					return true;
				}
			}
		}

		//if no path from a particular src to dest return false;
		return false;

	}

}