package dsalevel1.basics.twodarrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SpiralDisplay {

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
		int wall = 0;

		while (rmax >= rmin || cmax >= cmin) {

			wall = wall % 4;
			if (wall == 0) {
				for (int i = rmin; i <= rmax; i++) {
					System.out.println(a[i][cmin]);
				}
				cmin++;
				wall += 1;
			} else if (wall == 1) {
				for (int j = cmin; j <= cmax; j++) {
					System.out.println(a[rmax][j]);
				}
				rmax--;
				wall += 1;
			} else if (wall == 2) {
				for (int i = rmax; i >= rmin; i--) {
					System.out.println(a[i][cmax]);
				}
				cmax--;
				wall += 1;
			} else if (wall == 3) {
				for (int j = cmax; j >= cmin; j--) {
					System.out.println(a[rmin][j]);
				}
				rmin++;
				wall += 1;
			}

		}

	}

}
