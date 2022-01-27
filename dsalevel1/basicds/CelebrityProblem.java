package dsalevel1.basicds.stacks;

import java.io.*;
import java.util.*;

public class CelebrityProblem {

	public static void main(String[] args) throws Exception {
		// write your code here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];

		for (int j = 0; j < n; j++) {
			String line = br.readLine();
			for (int k = 0; k < n; k++) {
				arr[j][k] = line.charAt(k) - '0';
			}
		}

		findCelebrity(arr);

	}

	public static void findCelebrity(int[][] arr) {
		// if a celebrity is there print it''s index (not position), if there is not
		// then
		// print "none"
		int n = arr.length;
		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < n; i++) {
			st.push(i);
		}

		while (st.size() > 1) {

			int col = st.pop();
			int row = st.pop();

			if (arr[row][col] == 1) {
				st.push(col);
			} else {
				st.push(row);
			}
		}

		int celeb = st.peek();

		for (int i = 0; i < n; i++) {
			if (celeb == i) {
				continue;
			}
			if (arr[celeb][i] == 1) {
				System.out.println("none");
				return;
			}
			if (arr[i][celeb] == 0) {
				System.out.println("none");
				return;
			}
		}
		System.out.println(celeb);		
	}
}
