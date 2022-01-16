package dsalevel1.recursionandbacktracking.recursionwitharraylist;

import java.util.*;

public class GetMazePathWithJumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		in.close();
		ArrayList<String> ans = getMazePaths(0, 0, n - 1, m - 1);
		System.out.println(ans);
	}

	public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

		if (sr == dr && sc == dc) {
			ArrayList<String> al = new ArrayList<>();
			al.add("");
			return al;
		}
		
		ArrayList<String> ans = new ArrayList<>();
		// horizontal jumps
		for (int h_jumps = 1; sc + h_jumps <= dc; h_jumps++) {

			ArrayList<String> sans = getMazePaths(sr, sc + h_jumps, dr, dc);
			for (int i = 0; i < sans.size(); i++) {
				String s = sans.get(i);
				String t = "h" + h_jumps + s;
				ans.add(t);
			}
		}

		// vertical jumps
		for (int v_jumps = 1; sr + v_jumps <= dr; v_jumps++) {

			ArrayList<String> sans1 = getMazePaths(sr + v_jumps, sc, dr, dc);
			for (int i = 0; i < sans1.size(); i++) {
				String s = sans1.get(i);
				String t = "v" + v_jumps + s;
				ans.add(t);
			}
		}

		// diagonal jumps
		for (int d_jumps = 1; sc + d_jumps <= dc && sr + d_jumps <= dr; d_jumps++) {

			ArrayList<String> sans2 = getMazePaths(sr + +d_jumps, sc + d_jumps, dr, dc);
			for (int i = 0; i < sans2.size(); i++) {
				String s = sans2.get(i);
				String t = "d" + d_jumps + s;
				ans.add(t);
			}
		}

		return ans;
	}

}
