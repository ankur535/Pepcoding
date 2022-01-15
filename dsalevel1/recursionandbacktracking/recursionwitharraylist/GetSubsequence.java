package dsalevel1.recursionandbacktracking.recursionwitharraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class GetSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str = in.next();
		in.close();
		ArrayList<String> ans = gss(str);
		System.out.println(ans);
	}

	public static ArrayList<String> gss(String str) {

		if (str.length() == 0) {
			ArrayList<String> ans = new ArrayList<String>();
			ans.add("");
			return ans;
		}

		ArrayList<String> smallAns = gss(str.substring(1));

		ArrayList<String> ans = new ArrayList<String>();
		char c = str.charAt(0);

		for (int i = 0; i < smallAns.size(); i++) {
			String s = smallAns.get(i);
			ans.add(s);
		}

		for (int i = 0; i < smallAns.size(); i++) {
			String s = smallAns.get(i);
			s = c + s;
			ans.add(s);
		}

		return ans;
		
		/* Or this can be done within same ArrayList
        
        ArrayList<String> smallAns = gss(str.substring(1));
		
		char firstChar = str.charAt(0);
		int n = smallAns.size();
		
		for (int i = 0; i < n; i++) {
			String s = smallAns.get(i);
			s = firstChar + s;
			smallAns.add(s);
		}
		
        return smallAns;
        
        */
        

	}

}
