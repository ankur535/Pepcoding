package dsalevel2.advancedds.graphs;

import java.io.*;
import java.util.*;

class OptimizeWaterDistribution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] st = br.readLine().split(" ");
		int v = Integer.parseInt(st[0]);
		int e = Integer.parseInt(st[1]);

		int[] wells = new int[v];
		String[] words = br.readLine().split(" ");

		for (int i = 0; i < wells.length; i++) {
			wells[i] = Integer.parseInt(words[i]);
		}

		int[][] pipes = new int[e][3];
		for (int i = 0; i < e; i++) {
			String[] st1 = br.readLine().split(" ");
			pipes[i][0] = Integer.parseInt(st1[0]);
			pipes[i][1] = Integer.parseInt(st1[1]);
			pipes[i][2] = Integer.parseInt(st1[2]);

		}

		System.out.println(minCostToSupplyWater(v, wells, pipes));
	}

	public static int leader(int u) {
		if (par[u] == u)
			return u;

		int pu = leader(par[u]);

		return par[u] = pu;
	}

	public static void merge(int pu, int pv) {

		if (size[pu] < size[pv]) {
			par[pu] = pv;
			size[pv] += size[pu];
		} else {
			par[pv] = pu;
			size[pu] += size[pv];
		}
	}

	static int[] par;
	static int[] size;

	// @SuppressWarnings("unchecked")
	public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {

		int e = pipes.length;

		// creating new pipes array with extra edges
		int[][] npipes = new int[e + n][3];

		for (int i = 0; i < e; i++) {
			npipes[i][0] = pipes[i][0];
			npipes[i][1] = pipes[i][1];
			npipes[i][2] = pipes[i][2];
		}

		// this will remove dependency on well creation and remove it with extra pipe edges
		// this will help in kruskal implementation of MST
		int j = 1;
		for (int i = e; i < e + n; i++, j++) {
			npipes[i][0] = 0;
			npipes[i][1] = j;
			npipes[i][2] = wells[j - 1];
		}

		//No need to create MST
		// ArrayList<int[]>[] mst = new ArrayList[n];

		par = new int[n + 1];
		size = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			// mst[i] = new ArrayList<>();
			par[i] = i;
			size[i] = 1;
		}

		// Sorting edges for Kruskal
		Arrays.sort(npipes, (int a[], int b[]) -> {
			return a[2] - b[2];
		});

		int total_weight = 0;

		//Similar to Kruskal or Union Find
		for (int[] edge : npipes) {

			int u = edge[0];
			int v = edge[1];
			int w = edge[2];

			int pu = leader(u);
			int pv = leader(v);

			if (pu != pv) {
				merge(pu, pv);
				total_weight += w;
			}
		}

		return total_weight;
	}
}