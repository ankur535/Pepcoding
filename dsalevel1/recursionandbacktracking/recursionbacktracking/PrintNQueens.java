package dsalevel1.recursionandbacktracking.recursionbacktracking;

import java.util.Scanner;

public class PrintNQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		boolean[][] chess = new boolean[n][n];
		printNQueens(chess, "", 0);

	}

	public static void printNQueens(boolean[][] chess, String qsf, int row) {

		if(row == chess.length) {
			System.out.println(qsf + ".");
			return;
		}
		
		for (int col = 0; col < chess.length; col++) {
			if (isQueenSafe(chess, row, col)) {
				chess[row][col] = true;
				printNQueens(chess, qsf + row + "-" + col + ", ", row + 1);
				chess[row][col] = false;
			}
		}
	}

	public static boolean isQueenSafe(boolean[][] chess, int row, int col) {

		int n = chess.length;
		int[][] dirs = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
		
		
		for (int dis = 1; dis < n; dis++) {
			for (int i = 0; i <8; i++) {
				
				int rm = dirs[i][0];
				int cm = dirs[i][1];
				
				int nrow = row + dis*rm;
				int ncol = col + dis*cm;
				
				if(nrow >= 0 && ncol >= 0 && nrow < n && ncol <n) {
					if(chess[nrow][ncol] == true) {
						return false;
					}
				}
			}
		}
		return true;
	}
}