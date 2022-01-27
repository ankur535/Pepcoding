package dsalevel1.basicds.stacks;

import java.io.*;
import java.util.*;

public class SlidingWindowMaximum {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		int k = Integer.parseInt(br.readLine());

		int ans[] = slidingWindow(a, k);

		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
		// code
	}

	public static int[] slidingWindow(int[] a, int k) {

		int n = a.length;
		int nmr[] = nextMaximumToRight(a);

		int ans[] = new int[n - k + 1];
		int idx = 0;
		for (int si = 0; si <= n - k; si++) {

			int ei = si + k - 1;

			if (idx < si) {
				idx = si;
			}

			while (nmr[idx] <= ei) {
				idx = nmr[idx];
			}

			ans[si] = a[idx];
		}
		return ans;
	}

	public static int[] nextMaximumToRight(int[] arr) {
		// solve
		int n = arr.length;
		Stack<Integer> st = new Stack<>();
		int nmr[] = new int[n];

		nmr[n - 1] = n;
		st.push(n - 1);

		for (int i = n - 2; i >= 0; i--) {

			int val = arr[i];

			while (st.size() != 0 && arr[st.peek()] <= val) {
				st.pop();
			}

			if (st.size() == 0) {
				nmr[i] = n;
			} else {
				nmr[i] = st.peek();
			}
			st.push(i);
		}
		return nmr;
	}
}
