package dsalevel1.basics.twodarrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExitPointOfAMatrix {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine().trim());
		int m = Integer.parseInt(br.readLine().trim());
		int a[][] = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(br.readLine());
			}
		}

		int direction = 0;
		int row = 0;
		int col = 0;

		while (row >= 0 && row < n && col >= 0 && col < m) {

			if (a[row][col] == 1) {
				direction++;
				direction = direction % 4;
			}

			if (direction == 0) {
				col++;
			}

			if (direction == 1) {
				row++;
			}

			if (direction == 2) {
				col--;
			}

			if (direction == 3) {
				row--;
			}
		}

		if (row < 0)
			row = 0;
		if (row >= n)
			row = n - 1;
		if (col < 0)
			col = 0;
		if (col >= m)
			col = m - 1;

		System.out.println(row);
		System.out.println(col);

	}

}
