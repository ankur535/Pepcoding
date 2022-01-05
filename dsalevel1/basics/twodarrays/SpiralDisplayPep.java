package dsalevel1.basics.twodarrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SpiralDisplayPep {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int a[][] = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(br.readLine());
			}
		}

		int rmin = 0;
		int rmax = n - 1;
		int cmin = 0;
		int cmax = m - 1;

		int total = n * m;
		int count = 0;

		while (count < total) {

			// left wall
			if (count < total) {
				for (int i = rmin; i <= rmax; i++) {
					System.out.println(a[i][cmin]);
					count++;
				}
				cmin++;
			}

			// bottom wall
			if (count < total) {
				for (int j = cmin; j <= cmax; j++) {
					System.out.println(a[rmax][j]);
					count++;
				}
				rmax--;
			}

			// right wall
			if (count < total) {
				for (int i = rmax; i >= rmin; i--) {
					System.out.println(a[i][cmax]);
					count++;
				}
				cmax--;
			}

			// top wall
			if (count < total) {
				for (int j = cmax; j >= cmin; j--) {
					System.out.println(a[rmin][j]);
					count++;
				}
				rmin++;
			}

		}

	}

}
