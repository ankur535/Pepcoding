package dsalevel1.basicds.stacks;

import java.io.*;
import java.util.*;

public class NextGreaterElementToTheRight {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}

		int[] nge = solve(a);
		display(nge);
	}

	public static int[] solve(int[] arr) {
		// solve
		int n = arr.length;
		Stack<Integer> st = new Stack<>();
		int ans[] = new int[n];

		ans[n - 1] = -1;
		st.push(arr[n - 1]);

		for (int i = n - 2; i >= 0; i--) {

			int val = arr[i];

			while (st.size() != 0 && st.peek() <= val) {
				st.pop();
			}

			if (st.size() == 0) {
				ans[i] = -1;
			} else {
				ans[i] = st.peek();
			}
			st.push(val);
		}
		return ans;
	}

	public static void display(int[] a) {
		StringBuilder sb = new StringBuilder();

		for (int val : a) {
			sb.append(val + "\n");
		}
		System.out.println(sb);
	}

}
