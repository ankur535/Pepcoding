package dsalevel1.recursionandbacktracking.recursionbacktracking;

import java.util.Scanner;

public class FloodFillWithoutBooleanVis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = in.nextInt();
            }
        }
		floodfill(arr, 0, 0, "");
		in.close();
	}

	// asf -> answer so far
	public static void floodfill(int[][] maze, int sr, int sc, String asf) {

		int n = maze.length;
		int m = maze[0].length;

		if (sr == n-1 && sc == m-1) {
			System.out.println(asf);
			return;
		}

		if (sr < 0 || sc < 0 || sr >= n || sc >= m || maze[sr][sc] == 1) {
			return;
		}

		maze[sr][sc] = 1;
		// top
		floodfill(maze, sr - 1, sc, asf + "t");
		// left
		floodfill(maze, sr, sc - 1, asf + "l");
		// down
		floodfill(maze, sr + 1, sc, asf + "d");
		// right
		floodfill(maze, sr, sc + 1, asf + "r");

		maze[sr][sc] = 0;

	}
}
