package dsalevel1.recursionandbacktracking.recursioninarrays;

import java.io.*;

public class AllIndicesOfArray {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int x = Integer.parseInt(br.readLine());
		int[] iarr = allIndices(arr, x, 0, 0);

		if (iarr.length == 0) {
			System.out.println();
			return;
		}

		for (int i = 0; i < iarr.length; i++) {
			System.out.println(iarr[i]);
		}
	}

	public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
		// fsf - found so far
		// write ur code here
		if (idx == arr.length) {
			return new int[fsf];
		}

		if (x == arr[idx]) {
			fsf = fsf + 1;
		}
		int iarr[] = allIndices(arr, x, idx + 1, fsf);
		if (x == arr[idx]) {
			iarr[fsf - 1] = idx;
		}

		return iarr;
	}

}
