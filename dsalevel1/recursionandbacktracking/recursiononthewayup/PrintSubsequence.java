package dsalevel1.recursionandbacktracking.recursiononthewayup;

import java.util.*;

public class PrintSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str = in.next();
		in.close();
		printSS(str, "");
	}

	public static void printSS(String str, String ans) {

		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = str.charAt(0);
		String leftOverString = str.substring(1);

		printSS(leftOverString, ans + ch);

		printSS(leftOverString, ans);

	}

}
