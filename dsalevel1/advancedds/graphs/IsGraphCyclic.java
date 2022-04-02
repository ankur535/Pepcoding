package dsalevel1.advancedds.graphs;

import java.io.*;
import java.util.*;

public class IsGraphCyclic {
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
		boolean isCycle = false;

		boolean[] vis = new boolean[vtces];

		// travel on each vertex, as graph can be unconnected
		for (int i = 0; i < vtces; i++) {
			if (!vis[i]) {
				// call isCyclic if vertex not yet visited
				if (isGraphCyclic(graph, i, vis)) {
					// if cycle is true at any point, break and print true
					isCycle = true;
					break;
				}
				/*
				  Or this can be done
				 
				  isCycle = isCycle || isCyclic(graph, i, vis);
				 */
			}
		}

		System.out.println(isCycle);
	}

	public static boolean isGraphCyclic(ArrayList<Edge>[] graph, int src, boolean[] vis) {

		// Do Breadth First Traversal
		LinkedList<Integer> que = new LinkedList<>();
		que.addLast(src);

		while (que.size() > 0) {
			int size = que.size();

			while (size-- > 0) {
				int top = que.removeFirst();

				// here checking if top already got popped out of queue
				// that means that element came twice in queue and that is possible
				// only if there is cycle in graph, so return true
				if (vis[top])
					return true;

				vis[top] = true;

				// insert each neighbour of top vertex
				for (Edge e : graph[top]) {
					int nbr = e.nbr;
					if (!vis[nbr]) {
						que.add(nbr);
					}
				}
			}
		}

		return false;
	}

}