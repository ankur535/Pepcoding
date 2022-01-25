package dsalevel1.recursionandbacktracking.recursiononthewayup;

import java.util.Scanner;

public class PrintEncodings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str = in.next();
		in.close();
		printEncodings(str, "");
	}

	public static void printEncodings(String str, String asf) {

		if (str.length() == 0) {
			System.out.println(asf);
			return;
		}

		char ch = str.charAt(0);
		if (ch == '0') {
			return;
		}

		String to_add = (char) ('a' + Integer.parseInt(ch + "") - 1) + "";
		String ros = str.substring(1);

		printEncodings(ros, asf + to_add);

		if (str.length() >= 2) {

			String to_chars = str.substring(0, 2);
			int idx = Integer.parseInt(to_chars);
			String ros12 = str.substring(2);

			if (idx >= 1 && idx <= 26) {
				String to_add1 = (char) ('a' + idx - 1) + "";
				printEncodings(ros12, asf + to_add1);
			}

		}

	}

}
