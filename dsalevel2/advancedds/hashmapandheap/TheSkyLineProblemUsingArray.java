package dsalevel2.advancedds.hashmapandheap;

import java.util.*;

public class TheSkyLineProblemUsingArray {

	public static List<List<Integer>> getSkyline(int[][] buildings) {
		// write your code here

		int n = buildings.length;
		
		//array to store (start, -height) and (end, height) for each building
		int[][] arr = new int[2*n][2];
		
		int k = 0;
		
		//fill array for (start, -height) and (end, height) for each building 
		for (int i = 0; i < n; i++) {
			
			int sp = buildings[i][0];
			int ep = buildings[i][1];
			int height = buildings[i][2];
			
			//start point with negative height
			arr[k][0] = sp;
			arr[k][1] = -1 * height;
			
			k++;
			
			//end point with positive height
			arr[k][0] = ep;
			arr[k][1] = height;
			
			k++;			
		}
		
		Arrays.sort(arr, (int a[], int b[]) -> {
			//if start or end point at any point is same, sort based on their height
			if (a[0] == b[0]) {
				return a[1] - b[1];
			} else {
				//else sort base on start and end points, to travel on x-axis
				return a[0] - b[0];
			}
		});
		
		List<List<Integer>> ans = new ArrayList<>();
		
		//current height
		int ch = 0;
		
		//Max Priority queue for storing height at starting point and removing
		//at ending point
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		pq.add(ch);
		
		for (int i = 0; i < arr.length; i++) {
			
			//start or end point with height
			int x = arr[i][0];
			int h = arr[i][1];
			
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
