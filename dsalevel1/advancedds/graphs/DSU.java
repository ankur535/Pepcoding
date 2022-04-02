package dsalevel1.advancedds.graphs;

import java.util.*;

//This is Union Find or Disjoint Set Union (DSU)
//Very simple code
public class DSU {

	public static void main(String[] args) {
		
	}
	
	//leader and size array
	int par[];
	int size[];
	
	@SuppressWarnings("unchecked")
	public ArrayList<Integer>[] createSpanningTree(int V, int[][] edges) {
		
		ArrayList<Integer>[] graph = new ArrayList[V];
		
		par = new int[V];
		size = new int[V];
		
		//making leader(i) -> i and size as 1
		for (int i = 0; i < V; i++) {
			graph[i] = new ArrayList<>();
			par[i] = i;
			size[i] = 1;
		}
		
		for (int[] edge: edges) {
			int u = edge[0];
			int v = edge[1];
			
			//find leader of u and v
			int lu = findLeader(u);
			int lv = findLeader(v);
			
			//not part of 1 component
			if (lu != lv) {
				merge(lu, lv);
				addEdge(graph, u, v);
			}
		}
		
		return graph;
	}
	
	public int findLeader(int u) {
		
		if (par[u] == u) {
			return u;
		}
		
		//ultimate leader
		int ul = findLeader(par[u]);
		//path compression
		par[u] = ul;
		
		return ul;		
	}
	
	//correct new parent and size
	public void merge(int lu, int lv) {
		
		if (size[lu] >= size[lv]) {
			//lu is new parent/leader and increase size of lu
			par[lv] = lu;
			size[lu] += size[lv];
		} else {
			//lv is new parent/leader and increase size of lv
			par[lu] = lv;
			size[lv] += size[lu];
		}	
	}
	
	public void addEdge(ArrayList<Integer>[] graph, int u, int v) {
		//undirected graph
		graph[u].add(v);
		graph[v].add(u);
	}
	
}
