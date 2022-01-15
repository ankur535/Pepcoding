package dsalevel1.recursionandbacktracking.recursionwitharraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class GetKPC {

	static String arr[] = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str = in.next();
		in.close();
		ArrayList<String> ans = getKPC(str);
		System.out.println(ans);
	}

	public static ArrayList<String> getKPC(String str) {

		if (str.length() == 0) {
			ArrayList<String> al = new ArrayList<String>();
			al.add("");
			return al;
		}

		ArrayList<String> ans = getKPC(str.substring(1));

		ArrayList<String> nAns = new ArrayList<String>();
		char c = str.charAt(0);
		int val = Integer.parseInt(c + "");
		String key = arr[val];

		for (int i = 0; i < key.length(); i++) {
			char c1 = key.charAt(i);
			for (int j = 0; j < ans.size(); j++) {
				String s = c1 + ans.get(j);
				nAns.add(s);
			}
		}
		
		return nAns;

	}

}
