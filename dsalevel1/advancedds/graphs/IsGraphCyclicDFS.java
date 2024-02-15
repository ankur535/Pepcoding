package dsalevel1.advancedds.graphs;

import java.io.*;
import java.util.*;

public class IsGraphCyclicDFS {
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
		boolean[] vis = new boolean[vtces];
		
		boolean cycle = isCycle(graph, -1, src, vis);
		System.out.println(cycle);
		
	}
	
	//Major issue with DFS is late detection of cycle in some cases.
	public static boolean isCycle(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
		
		vis[dest] = true;
		System.out.println("Enter " + src + " " + dest);
		
		for (Edge e: graph[dest]) {
			
			int nbr = e.nbr;
			
			if (nbr == src) continue;
			
			if (!vis[nbr]) {
				boolean iss = isCycle(graph, dest, nbr, vis);
				if (iss) return iss;
			} else {
				return true;
			}	
		}
		
		vis[dest] = false;
		System.out.println("Exit " + src + " " + dest);
		return false;
	}

}