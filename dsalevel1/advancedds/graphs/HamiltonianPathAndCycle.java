package dsalevel1.advancedds.graphs;

import java.io.*;
import java.util.*;

public class HamiltonianPathAndCycle {
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

		int src = Integer.parseInt(br.readLine());
		// need count to track if all verteces are visited
		int count = vtces;
		String psf = "";

		// write all your codes here
		printHamiltonianPath(graph, src, src, count - 1, psf + src, new boolean[vtces]);
	}

	public static void printHamiltonianPath(ArrayList<Edge>[] graph, int src, int vtx, int count, String psf,
			boolean[] vis) {

		// if all vertex are visited
		if (count == 0) {

			boolean isCycle = false;

			// see if last vertex has any neighbout as source, then cycle
			for (Edge e : graph[vtx]) {
				int nbr = e.nbr;
				if (nbr == src) {
					isCycle = true;
					break;
				}
			}
			System.out.print(psf);
			if (isCycle) {
				System.out.println("*");
			} else {
				System.out.println(".");
			}
			
			return;
		}

		vis[vtx] = true;

		// normal DFS traversal
		for (Edge e : graph[vtx]) {
			int nbr = e.nbr;
			if (!vis[nbr]) {
				printHamiltonianPath(graph, src, nbr, count - 1, psf + nbr, vis);
			}
		}

		vis[vtx] = false;
	}
}