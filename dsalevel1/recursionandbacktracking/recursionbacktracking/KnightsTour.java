package dsalevel1.recursionandbacktracking.recursionbacktracking;

import java.util.Scanner;

public class KnightsTour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int row = in.nextInt();
		int col = in.nextInt();
		
		int[][] chess = new int[n][n];
		printKnightsTour(chess, row, col, 1);
		in.close();
		
	}

	
	/*
	 * incomplete code
	 * 
	 */
	public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {

		int n = chess.length;
		
		if (r < 0 || c < 0 || r >= n || c >= n || chess[r][c] != 0) {
			return;
		}
		
		if(upcomingMove == n*n) {
			chess[r][c] = upcomingMove;
			displayBoard(chess);
			chess[r][c] = 0;
			return;
		}
		
		chess[r][c] = upcomingMove;
		//call 1
		printKnightsTour(chess, r - 2, c + 1, upcomingMove + 1);
		//call 2
		printKnightsTour(chess, r - 1, c + 2, upcomingMove + 1);
		//call 3
		printKnightsTour(chess, r + 1, c + 2, upcomingMove + 1);
		//call 4
		printKnightsTour(chess, r + 2, c + 1, upcomingMove + 1);
		// call 5
		printKnightsTour(chess, r + 2, c - 1, upcomingMove + 1);
		// call 6
		printKnightsTour(chess, r + 1, c - 2, upcomingMove + 1);
		// call 7
		printKnightsTour(chess, r - 1, c - 2, upcomingMove + 1);
		// call 8
		printKnightsTour(chess, r - 2, c - 1, upcomingMove + 1);
	
		chess[r][c] = 0;
	}

	public static void displayBoard(int[][] chess) {
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess[0].length; j++) {
				System.out.print(chess[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println();
	}
}
