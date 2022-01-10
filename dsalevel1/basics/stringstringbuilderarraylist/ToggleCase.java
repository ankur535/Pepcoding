package dsalevel1.basics.stringstringbuilderarraylist;

import java.util.Scanner;

public class ToggleCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str = in.next();
		System.out.println(toggleCase(str));
		in.close();
	}

	public static String toggleCase(String str) {
		// write your code here
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (Character.isLowerCase(c)) {
				sb.append(Character.toUpperCase(c));
			} else if (Character.isUpperCase(c)) {
				sb.append(Character.toLowerCase(c));
			} else {
				sb.append(c);
			}

		}

		return sb.toString();
	}

}
