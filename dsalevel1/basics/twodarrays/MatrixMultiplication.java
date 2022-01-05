 package dsalevel1.basics.twodarrays;

import java.util.Scanner;

public class MatrixMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int m1 = in.nextInt();
		int a1[][] = new int[n1][m1];
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < m1; j++) {
				a1[i][j] = in.nextInt();
			}
		}
		int n2 = in.nextInt();
		int m2 = in.nextInt();
		int a2[][] = new int[n2][m2];
		for (int i = 0; i < n2; i++) {
			for (int j = 0; j < m2; j++) {
				a2[i][j] = in.nextInt();
			}
		}
		in.close();
		
		if (m1 == n2) {
			
			int product[][] = new int[n1][m2];
			
			for (int i = 0; i < n1; i++) {
				for (int j = 0; j < m2; j++) {
					for (int k = 0; k < m1; k++) {
						product[i][j] += a1[i][k] * a2[k][j];
					}
				}
			}
			for (int i = 0; i < n1; i++) {
				for (int j = 0; j < m2; j++) {
					System.out.print(product[i][j] + " ");
				}
				System.out.println();
			}
			
		} else {
			System.out.println("Invalid input");
		}
		
	}

}
