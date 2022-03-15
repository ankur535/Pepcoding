package dsalevel2.advancedds.hashmapandheap;

import java.util.*;

public class TheSkyLineProblemUsingClass {

	// Pair class instead of using an array of size 2
	public static class Pair implements Comparable<Pair> {
		int x;
		int h;

		public Pair(int x, int h) {
			this.x = x;
			this.h = h;
		}

		public int compareTo(Pair other) {
			if (this.x == other.x) {
				return this.h - other.h;
			} else {
				return this.x - other.x;
			}
		}
	}

	public static List<List<Integer>> getSkyline(int[][] buildings) {
		// write your code here

		// arraylist of Pairs instead of arr[2*n][2];
		ArrayList<Pair> points = new ArrayList<>();

		for (int b[] : buildings) {

			// start point, end point and height
			int sp = b[0];
			int ep = b[1];
			int height = b[2];

			// create (start, -height) and (end, height) pairs and add in list
			Pair sph = new Pair(sp, -1 * height);
			Pair eph = new Pair(ep, height);

			points.add(sph);
			points.add(eph);
		}

		// Sort the list using Pair class compareTo method
		Collections.sort(points);

		List<List<Integer>> ans = new ArrayList<>();

		// current height
		int ch = 0;

		// Max Priority queue for storing height at starting point and removing
		// at ending point
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		pq.add(ch);

		for (Pair p : points) {

			//start or end point with height
			int x = p.x;
			int h = p.h;

			//add positive height in PQ for start point and remove for end point of a building
			if (h < 0) {
				pq.add(-1 * h);
			} else {
				pq.remove(h);
			}

			int max_height = pq.peek();

			//if max height changes
			if (ch != max_height) {
				//add in smaller list for point with its changing height
				List<Integer> sans = new ArrayList<>();
				sans.add(x);
				sans.add(max_height);

				ans.add(sans);

				//update current height
				ch = max_height;
			}

		}

		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		List<List<Integer>> ans = getSkyline(arr);
		for (int i = 0; i < ans.size(); i++) {
			for (int j = 0; j < ans.get(i).size(); j++) {
				System.out.print(ans.get(i).get(j) + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}
