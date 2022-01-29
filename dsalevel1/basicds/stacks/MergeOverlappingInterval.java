package dsalevel1.basicds.stacks;

import java.io.*;
import java.util.*;

public class MergeOverlappingInterval {

	public static void main(String[] args) throws Exception {
		// write your code here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];

		for (int j = 0; j < n; j++) {
			String line = br.readLine();
			arr[j][0] = Integer.parseInt(line.split(" ")[0]);
			arr[j][1] = Integer.parseInt(line.split(" ")[1]);
		}

		mergeOverlappingIntervals(arr);
	}

	public static void mergeOverlappingIntervals(int[][] arr) {
		// merge overlapping intervals and print in increasing order of start time

		Arrays.sort(arr, (int[] a, int[] b) -> {
			return a[0] - b[0];
		});

		Stack<int[]> intervals = new Stack<>();
		intervals.push(arr[0]);

		for (int i = 1; i < arr.length; i++) {

			int st = arr[i][0];
			int et = arr[i][1];

			if (st <= intervals.peek()[1]) {

				int[] prev_interval = intervals.pop();
				int[] merged_interval = new int[2];

				merged_interval[0] = prev_interval[0];
				merged_interval[1] = Math.max(prev_interval[1], et);

				intervals.push(merged_interval);
			} else {
				intervals.push(arr[i]);
			}
		}
		
		Stack<int[]> temp = new Stack<>();
		while (intervals.size() > 0) {
			temp.push(intervals.pop());
		}
		
		while (temp.size() > 0) {
			int[] inter = temp.pop();
			System.out.println(inter[0] + " " + inter[1]);
		}
	}
}
