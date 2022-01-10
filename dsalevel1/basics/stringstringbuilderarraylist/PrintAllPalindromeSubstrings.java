package dsalevel1.basics.stringstringbuilderarraylist;

import java.util.Scanner;

public class PrintAllPalindromeSubstrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str = in.next();
		solution(str);
		in.close();
	}

	public static void solution(String str) {
		// write your code here

		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				String subString = str.substring(i, j);
				if (isPalindrome(subString)) {
					System.out.println(subString);
				}
			}
		}

	}

	public static boolean isPalindrome(String str) {
		
		int i = 0;
		int j = str.length() - 1;

		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}

		return true;
	}

}
