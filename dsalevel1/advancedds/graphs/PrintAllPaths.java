package dsalevel1.advancedds.graphs;

import java.io.*;
import java.util.*;

public class PrintAllPaths {
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
		int dest = Integer.parseInt(br.readLine());

		// write all your codes here
		
		String psf = src + "";
		
		printAllPaths(src, dest, graph, psf, new boolean[vtces]);
	}
	
	public static void printAllPaths(int src, int dest, ArrayList<Edge>[] graph, String psf, boolean[] vis) {
		
		//if src == dest print path and return
		if (src == dest) {
			System.out.println(psf);
			return;
		}		
		
		vis[src] = true;
		
		for (Edge e: graph[src]) {
			
			int nbr = e.nbr;
			
			//is nbr not visisted, visit from that neighbout to dest
			if (!vis[nbr]) {
				printAllPaths(nbr, dest, graph, psf + nbr, vis);
			}
		}
		
		//once going back from vertex, make vis again false
		//for backtacking and multiple paths
		vis[src] = false;
	}

}