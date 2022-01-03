package dsalevel1.basics.functionsandarrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SubsetOfArray {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int a[] = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}

		susbsetArray(a, n);
		br.close();

	}

	public static void susbsetArray(int[] a, int n) {
		// TODO Auto-generated method stub
		int num = (int) Math.pow(2, n);

		for (int i = 0; i < num; i++) {
			String str = "";
			int val = i;
			for (int j = n - 1; j >= 0; j--) {
				int rem = val % 2;
				if (rem == 1) {
					str = a[j] + "\t" + str;
				} else {
					str = "-\t" + str;
				}
				val = val / 2;
			}
			System.out.println(str);
		}

	}

}
