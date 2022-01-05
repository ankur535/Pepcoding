package dsalevel1.basics.twodarrays;

import java.util.Scanner;

public class RingRotatePep2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();
		int arr[][] = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		int s = in.nextInt();
		int k = in.nextInt();
		in.close();

		int shell[] = getOneDArray(arr, s);

		rotateArray(shell, k);

		fillArray(arr, shell, s);

		display(arr);

	}

	public static void fillArray(int arr[][], int shell[], int s) {
		int rmin = s - 1;
		int rmax = arr.length - s;
		int cmin = s - 1;
		int cmax = arr[0].length - s;

		int var = shell.length;
		int idx = 0;

		// left wall
		if (idx < var) {
			for (int i = rmin; i <= rmax; i++) {
				arr[i][cmin] = shell[idx];
				idx++;
			}
		}
		cmin++;

		// bottom wall
		if (idx < var) {
			for (int j = cmin; j <= cmax; j++) {
				arr[rmax][j] = shell[idx];
				idx++;
			}
		}
		rmax--;

		// right wall
		if (idx < var) {
			for (int i = rmax; i >= rmin; i--) {
				arr[i][cmax] = shell[idx];
				idx++;
			}
		}
		cmax--;

		// top wall
		if (idx < var) {
			for (int j = cmax; j >= cmin; j--) {
				arr[rmin][j] = shell[idx];
				idx++;
			}
		}
		rmin++;
	}

	public static void reverse(int a[], int i, int j) {
		while (i <= j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
	}

	public static void rotateArray(int shell[], int k) {

		int n = shell.length;
		k = k % n;
		if (k < 0) {
			k = k + n;
		}

		// reverse 1st part
		reverse(shell, 0, n - k - 1);

		// reverse 2nd part
		reverse(shell, n - k, n - 1);

		// reverse whole array
		reverse(shell, 0, n - 1);

	}

	public static int[] getOneDArray(int arr[][], int s) {

		int rmin = s - 1;
		int rmax = arr.length - s;
		int cmin = s - 1;
		int cmax = arr[0].length - s;

		int total = (rmax - rmin + 1) * (cmax - cmin + 1);
		int internalTotal = (rmax - rmin - 1) * (cmax - cmin - 1);
		if (internalTotal > 0) {
			total = total - internalTotal;
		}

		int shell[] = new int[total];
		int idx = 0;

		// left wall
		if (idx < total) {
			for (int i = rmin; i <= rmax; i++) {
				shell[idx] = arr[i][cmin];
				idx++;
			}
		}
		cmin++;

		// bottom wall
		if (idx < total) {
			for (int j = cmin; j <= cmax; j++) {
				shell[idx] = arr[rmax][j];
				idx++;
			}
		}
		rmax--;

		// right wall
		if (idx < total) {
			for (int i = rmax; i >= rmin; i--) {
				shell[idx] = arr[i][cmax];
				idx++;
			}
		}
		cmax--;

		// top wall
		if (idx < total) {
			for (int j = cmax; j >= cmin; j--) {
				shell[idx] = arr[rmin][j];
				idx++;
			}
		}
		rmin++;

		return shell;

	}

	public static void display(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
