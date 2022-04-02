package dsalevel1.advancedds.graphs;

import java.io.*;
import java.util.*;

public class BreadthFirstTraversal {
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

		// write your code here
		BFS(src, graph);
	}

	public static class Pair {
		int node;
		String path;

		public Pair(int node, String path) {
			this.node = node;
			this.path = path;
		}
	}

	public static void BFS(int src, ArrayList<Edge>[] graph) {

		int vtces = graph.length;

		// same as level order traversal
		LinkedList<Pair> que = new LinkedList<>();

		que.addLast(new Pair(src, src + ""));

		boolean[] vis = new boolean[vtces];
		//int level = 0;

		while (que.size() > 0) {

			int size = que.size();
			// System.out.println(level + "-------------");

			while (size-- > 0) {
				Pair top = que.removeFirst();

				int node = top.node;
				String path = top.path;

				// put all nbr of src node
				for (Edge e : graph[node]) {

					int nbr = e.nbr;

					// if nbr not visited, insert it and mark vis as true
					if (!vis[nbr]) {
						vis[nbr] = true;
						que.addLast(new Pair(nbr, path + nbr));
					}
				}

				// print node and path
				vis[node] = true;
				System.out.println(node + "@" + path);
			}

			//level++;
		}
	}

}