package dsalevel1.basics.functionsandarrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SubArrayProblem {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int a[] = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}

		printSubArray(a, n);
		br.close();
	}

	public static void printSubArray(int a[], int n) {
		
		int start = 0;
		for (int i = 0; i < n; i++) {
			for(int j = start; j <= i; j++) {
				System.out.print(a[j] + "\t");
			}
			if (i== (n-1)) {
				i= start;
				start++;
			}
			System.out.println();
		}
		
		/* Or this can also be done shifting i to else loop
		 int n = a.length - 1;
		int start = 0;
		for (int i = 0; i <= n;) {
			for (int j = start; j <= i; j++) {
				System.out.print(a[j] + "\t");
			}
			if (i == n) {
				start++;
				i = start;
			} else {
				i++;
			}
			System.out.println();
		}
		 
		 */
		
		/*  Or this can also be done shifting i to else loop
		 *  Ans from pep class
		 
		 for (int start = 0; start < n; start++) {
		 	for (int end = start; end < n; end++) {
				for (int k = start; k <= end; k++) {
					System.out.print(a[k] + "\t");
				}
				System.out.println();
			}
		}
		 */
		
	}

}
