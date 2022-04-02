package dsalevel1.advancedds.graphs;

import java.util.*;

public class KnightTour {

	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int r = in.nextInt();
		int c = in.nextInt();

		int chess[][] = new int[n][n];
		printKnightsTour(chess, r, c, 1);
		in.close();
	}

	public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {

		chess[r][c] = upcomingMove;
		int n = chess.length;

		if (upcomingMove == (n * n)) {
			displayBoard(chess);
		}

		int[][] dirs = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };

		for (int[] dir : dirs) {
			int nr = r + dir[0];
			int nc = c + dir[1];

			if (nr >= 0 && nc >= 0 && nr < n && nc < n && chess[nr][nc] == 0) {
				printKnightsTour(chess, nr, nc, upcomingMove + 1);
			}
		}
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