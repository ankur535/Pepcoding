package dsalevel1.advancedds.graphs;

import java.io.*;
import java.util.*;

public class IsGraphBipartite {
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
		System.out.println(isGraphBipartite(graph));
	}

	public static boolean isGraphBipartite(ArrayList<Edge>[] graph) {

		int vtces = graph.length;

		int[] vis = new int[vtces];
		//fill attay with -1 for no color
		Arrays.fill(vis, -1);

		//call for all vertex as graph is unconnected
		for (int i = 0; i < vtces; i++) {
			if (vis[i] == -1) {
				if (!isEven(graph, i, vis)) {
					return false;
				}
			}
		}

		return true;
	}

	//Even Cycle or No cycle means Bipartite
    //Odd Cycle means not bipartite
	public static boolean isEven(ArrayList<Edge>[] graph, int src, int[] vis) {

		LinkedList<Integer> que = new LinkedList<>();
		que.addLast(src);

		//color to represent group A or group B
		int color = 0;

		while (que.size() > 0) {

			int size = que.size();

			while (size-- > 0) {

				int top = que.removeFirst();

				if (vis[top] != -1) {
					//if visited color and this level color are different
                    //means odd cycle
					if (vis[top] != color) {
						return false;
					}
				}

				//mark visited at removal time
				vis[top] = color;

				//fill all neighbour who are not visited
				for (Edge e : graph[top]) {
					
					int nbr = e.nbr;
					if (vis[nbr] == -1) {
						que.addLast(nbr);
					}
				}
			}
			
			//change color between 0 and 1 for green and blue to understand
			color = (color + 1)%2;
		}

		return true;
	}

}