package dsalevel1.advancedds.graphs;

import java.io.*;
import java.util.*;

public class SpreadOfInfection2 {
	static class Edge {
		int src;
		int nbr;

		Edge(int src, int nbr) {
			this.src = src;
			this.nbr = nbr;
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
			graph[v1].add(new Edge(v1, v2));
			graph[v2].add(new Edge(v2, v1));
		}

		int src = Integer.parseInt(br.readLine());
		int t = Integer.parseInt(br.readLine());

		// write your code here
		System.out.println(countInfectedPersons(graph, src, t));
	}

	/**
	 * This code for mark visited at removal time
	 */
	public static int countInfectedPersons(ArrayList<Edge>[] graph, int src, int t) {

		int vtces = graph.length;

		boolean[] vis = new boolean[vtces];
		LinkedList<Integer> que = new LinkedList<>();

		//add src to que
		que.add(src);

		//take level for time and 
		//count for number of infected persons
		int level = 1;
		int count = 0;

		//level <= t for removal time
		while (que.size() > 0 && level <= t) {

			int size = que.size();

			while (size-- > 0) {

				int top = que.removeFirst();
				
				if (vis[top]) continue;
				
				//mark visited and count at removal time
				vis[top] = true;
				count++;
				
				for (Edge e: graph[top]) {
					int nbr = e.nbr;
					
					//if neighbour not visited, then addLast
					if (!vis[nbr]) {
						que.addLast(nbr);
					}
				}
			}
			
			level++;
		}
	
		//count will store total infected person including cource
		//and considering it at time 1 so next start from time 2
		return count;
	}

}