package dsalevel1.recursionandbacktracking.recursionwitharraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePaths {

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

		if (sr > dr || sc > dc) {
			ArrayList<String> al = new ArrayList<>();
			return al;
		}
		
		if(sr == dr && sc == dc) {
			ArrayList<String> al = new ArrayList<>();
			al.add("");
			return al;
		}
		
		ArrayList<String> ans = new ArrayList<>();

		ArrayList<String> ans1 = getMazePaths(sr, sc + 1, dr, dc);
		for (int i = 0; i < ans1.size(); i++) {
			String s = ans1.get(i);
			String path = "h" + s;
			ans.add(path);
		}

		ArrayList<String> ans2 = getMazePaths(sr + 1, sc, dr, dc);
		for (int i = 0; i < ans2.size(); i++) {
			String s = ans2.get(i);
			String path = "v" + s;
			ans.add(path);
		}
		
		return ans;
	}

}
