package dsalevel1.basics.stringstringbuilderarraylist;

import java.util.Scanner;

public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str = in.next();
		in.close();
		//Compression 1 with a different approach
		System.out.println(compression1(str));
		//PepCoding approach 
		System.out.println(compression2(str));
		//PepCoding approach
		System.out.println(compression3(str));
		//Compression 2 with a different approach
		System.out.println(compression4(str));
	}

	public static String compression1(String str) {

		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < str.length()) {
			int j = i;
			while (j < str.length() && str.charAt(i) == str.charAt(j)) {
				j++;
			}
			sb.append(str.charAt(i));
			i = j;
		}
		return sb.toString();
	}

	//Pepcoding class approach
	public static String compression2(String str) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < str.length()) {
			if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
				int count = 0;
				int j = i;
				while (j < str.length() && str.charAt(i) == str.charAt(j)) {
					count++;
					j++;
				}
				sb.append(str.charAt(i));
				sb.append(count);
				i = j;
			} else {
				sb.append(str.charAt(i));
				i++;
			}
		}
		return sb.toString();
	}
	
	//PepCoding class approach
	public static String compression3(String str) {
		// write your code here
		StringBuilder sb = new StringBuilder();

		int i = 0;
		while (i < str.length()) {
			if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
				int j = i;

				while (j < str.length() && str.charAt(j) == str.charAt(i)) {
					j++;
				}
				sb.append(str.charAt(i));
				i = j;
			} else {
				sb.append(str.charAt(i));
				i++;
			}

		}
		return sb.toString();
	}

	public static String compression4(String str) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < str.length()) {
			int count = 0;
			int j = i;
			while (j < str.length() && str.charAt(i) == str.charAt(j)) {
				count++;
				j++;
			}
			if (count == 1) {
				sb.append(str.charAt(i));
			} else {
				sb.append(str.charAt(i));
				sb.append(count);
			}
			i = j;
		}
		return sb.toString();
	}

}
