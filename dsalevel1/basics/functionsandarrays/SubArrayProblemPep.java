package dsalevel1.basics.functionsandarrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SubArrayProblemPep {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int a[] = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}

		printSubArray(a, n);

	}

	public static void printSubArray(int a[], int n) {

		int num = n * (n + 1) / 2;

		int k = 0;
		int col = k + 1;
		for (int i = 0; i < num; i++) {
			for (int j = k; j < col; j++) {
				System.out.print(a[j] + "\t");
			}
			if (col == n) {
				k++;
				col = k + 1;
			} else {
				col++;
			}
			System.out.println();
		}

	}

}
