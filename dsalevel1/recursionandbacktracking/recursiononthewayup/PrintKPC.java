package dsalevel1.recursionandbacktracking.recursiononthewayup;

import java.util.Scanner;

public class PrintKPC {

	static String arr[] = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str = in.next();
		in.close();
		printKPC(str, "");
	}

	public static void printKPC(String str, String asf) {

		if (str.length() == 0) {
			System.out.println(asf);
			return;
		}

		char ch = str.charAt(0);
		int idx = Integer.parseInt(ch + "");

		String key = arr[idx];

		for (int i = 0; i < key.length(); i++) {
			printKPC(str.substring(1), asf + key.charAt(i));
		}

	}

}
