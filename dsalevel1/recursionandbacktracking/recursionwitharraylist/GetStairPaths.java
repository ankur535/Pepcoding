package dsalevel1.recursionandbacktracking.recursionwitharraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class GetStairPaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		ArrayList<String> ans = getStairPaths(0, n);
		
		System.out.println(ans);
	}
	
	public static ArrayList<String> getStairPaths(int idx, int n) {
		
		if (idx == n) {
			ArrayList<String> al = new ArrayList<>();
			al.add("");
			return al;
		}
		
		if (idx > n) {
			ArrayList<String> al = new ArrayList<>();
			return al;
		}
		
		ArrayList<String> ans = new ArrayList<>();
		
		ArrayList<String> ans1 = getStairPaths(idx+1, n);
		for (int i = 0; i < ans1.size(); i++) {
			String s = ans1.get(i);
			String path = "1" + s;
			ans.add(path);
		}
		
		ArrayList<String> ans2 = getStairPaths(idx+2, n);
		for (int i = 0; i < ans2.size(); i++) {
			String s = ans2.get(i);
			String path = "2" + s;
			ans.add(path);
		}
		
		ArrayList<String> ans3 = getStairPaths(idx+3, n);
		for (int i = 0; i < ans3.size(); i++) {
			String s = ans3.get(i);
			String path = "3" + s;
			ans.add(path);
		}
	
		return ans;
		
	}

}
