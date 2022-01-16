package dsalevel1.recursionandbacktracking.recursionwitharraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class getStairPathsDownward {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		ArrayList<String> ans = getStairPathsDownwards(n);
		
		System.out.println(ans);
	}
	
	public static ArrayList<String> getStairPathsDownwards(int n) {
		
		if (n == 0) {
			ArrayList<String> al = new ArrayList<>();
			al.add("");
			return al;
		}
		
		if (n < 0) {
			ArrayList<String> al = new ArrayList<>();
			return al;
		}
		
		ArrayList<String> ans = new ArrayList<>();
		
		ArrayList<String> ans1 = getStairPathsDownwards(n-1);
		for (int i = 0; i < ans1.size(); i++) {
			String s = ans1.get(i);
			String path = "1" + s;
			ans.add(path);
		}
		
		ArrayList<String> ans2 = getStairPathsDownwards(n-2);
		for (int i = 0; i < ans2.size(); i++) {
			String s = ans2.get(i);
			String path = "2" + s;
			ans.add(path);
		}
		
		ArrayList<String> ans3 = getStairPathsDownwards(n-3);
		for (int i = 0; i < ans3.size(); i++) {
			String s = ans3.get(i);
			String path = "3" + s;
			ans.add(path);
		}
	
		return ans;
		
	}

}
