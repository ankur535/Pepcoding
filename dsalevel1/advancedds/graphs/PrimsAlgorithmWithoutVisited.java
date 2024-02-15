package dsalevel1.advancedds.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//Simplest algorithm, it's BFS onlu using priority queue
public class PrimsAlgorithmWithoutVisited {
	
	public static class Edge {
		int src;
		int nbr;
		int wt;

		public Edge(int src, int nbr, int wt) {
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}
	
	public static class Pair {
		int node;
		int parent;
		int weight;
		
		public Pair(int node, int parent, int weight) {
			this.node = node;
			this.parent = parent;
			this.weight = weight;
		}
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Edge>[] prims(ArrayList<Edge>[] graph, int src) {
		
		int V = graph.length;
		
		ArrayList<Edge>[] mst = new ArrayList[V];
		
		for (int i = 0; i < V; i++) {
			mst[i] = new ArrayList<>();
		}
		
		int[] dijk = new int[V];
		Arrays.fill(dijk, Integer.MAX_VALUE);
		
		PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> {
			return a.weight - b.weight;
		});
		
		//add initial pair, (src, parent, wt = 0)
		pq.add(new Pair(src, -1, 0));
		
		while (pq.size() > 0) {
			
			Pair top = pq.remove();
			
			int node = top.node;
			int parent = top.parent;
			int weight = top.weight;
			
			if (weight >= dijk[node]) continue;
			
			//if parent not -1, then add edge btw node and parent
			if (parent != -1) {
				addEdge(node, parent, weight, mst);
			}
			
			dijk[node] = weight;
			
			//add new pair in pq for neighbours
			for (Edge e: graph[node]) {
				int nbr = e.nbr;
				int wt = e.wt;
				
				if (wt < dijk[nbr] && parent != nbr) {
					pq.add(new Pair(nbr, node, wt));
				}
			}
		}
		
		return mst;
	}
	
	//addEdge btw src and parent with weight
	public static void addEdge(int node, int parent, int weight, ArrayList<Edge>[] mst) {
		mst[node].add(new Edge(node, parent, weight));
		mst[parent].add(new Edge(parent, node, weight));
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
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
		//int dest = Integer.parseInt(br.readLine());
		
		ArrayList<Edge>[] ans = prims(graph, src);
		for (ArrayList<Edge> al: ans) {
			for (Edge e: al) {
				System.out.print("(" + e.src + "," + e.nbr + "," + e.wt + ") , ");
			}
			System.out.println();
		}
	}
}
