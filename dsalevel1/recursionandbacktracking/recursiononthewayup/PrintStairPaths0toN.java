package dsalevel1.recursionandbacktracking.recursiononthewayup;

import java.util.*;

public class PrintStairPaths0toN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		printStairPaths(0, n, "");
	}

	public static void printStairPaths(int idx, int n, String path) {

		if (n == idx) {
			System.out.println(path);
			return;
		}

		if (idx > n) {
			return;
		}

		printStairPaths(idx + 1, n, path + "1");

		printStairPaths(idx + 2, n, path + "2");

		printStairPaths(idx + 3, n, path + "3");

	}

}
