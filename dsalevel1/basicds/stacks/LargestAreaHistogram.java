package dsalevel1.basicds.stacks;

import java.io.*;
import java.util.*;

public class LargestAreaHistogram {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}

		int nml[] = nextMinimumToLeft(a);
		int nmr[] = nextMinimumToRight(a);

		int maxArea = 0;

		for (int i = 0; i < n; i++) {

			int left_min = nml[i];
			int right_min = nmr[i];

			int height = a[i];
			int width = right_min - left_min - 1;

			int area = height * width;
			maxArea = Math.max(maxArea, area);

		}
		System.out.println(maxArea);

	}

	public static int[] nextMinimumToLeft(int[] a) {

		int n = a.length;
		int nml[] = new int[n];
		Stack<Integer> st = new Stack<>();

		nml[0] = -1;
		st.push(0);

		for (int i = 1; i < n; i++) {

			int val = a[i];

			while (st.size() != 0 && a[st.peek()] >= val) {
				st.pop();
			}

			if (st.size() == 0) {
				nml[i] = -1;
			} else {
				nml[i] = st.peek();
			}
			st.push(i);
		}
		return nml;
	}

	public static int[] nextMinimumToRight(int[] a) {

		int n = a.length;
		int nmr[] = new int[n];
		Stack<Integer> st = new Stack<>();

		nmr[n - 1] = n;
		st.push(n - 1);

		for (int i = n - 2; i >= 0; i--) {

			int val = a[i];

			while (st.size() != 0 && a[st.peek()] >= val) {
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
