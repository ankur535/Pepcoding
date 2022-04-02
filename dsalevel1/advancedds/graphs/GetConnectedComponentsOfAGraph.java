package dsalevel1.advancedds.graphs;

import java.io.*;
import java.util.*;

public class GetConnectedComponentsOfAGraph {
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

		ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

		// write your code here		//Very Easy problem and code is also simple
		//visited array
		boolean[] vis = new boolean[vtces];
		
		//iterate over each vertex
		for (int src = 0; src < vtces; src++) {
			
			//if vertex not visited, means it is starting of a new part of graph
			if (!vis[src]) {

				ArrayList<Integer> ans = new ArrayList<>();
				//fill ans with all connected components for src
				fillComponents(graph, src, vis, ans);
				//fill and in comps for larger/complete arraylist
				comps.add(ans);
			}
		}

		System.out.println(comps);
	}
	
	public static void fillComponents(ArrayList<Edge>[] graph, int src, boolean[] vis, ArrayList<Integer> ans) {
		
		//as soon as we come, mark vis as true and fill in arraylist
		vis[src] = true;
		ans.add(src);
		
		//simple travelling DFS like always
		for (Edge e: graph[src]) {
			
			int nbr = e.nbr;
			
			//if neighbour of src not visited, travel to that neighbour
			if (!vis[nbr]) {
				fillComponents(graph, nbr, vis, ans);
			}
		}
	}
}