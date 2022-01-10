package dsalevel1.basics.stringstringbuilderarraylist;

import java.util.Scanner;

public class StringWithDiffOfEveryTwoConsecutiveCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str = in.next();
		System.out.println(solution(str));
		in.close();
	}
	
	public static String solution(String str){
		// write your code here
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < str.length(); i++) {
			char curr = str.charAt(i);
			if (i + 1 < str.length()) {
				char next = str.charAt(i+1);
				int gap = next - curr;
				
				sb.append(curr);
				sb.append(gap);
			} else {
				sb.append(curr);
			}
			
		}
		
		return sb.toString();
	}

}
