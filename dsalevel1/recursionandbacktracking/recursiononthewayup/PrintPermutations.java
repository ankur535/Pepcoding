package dsalevel1.recursionandbacktracking.recursiononthewayup;

import java.util.Scanner;

public class PrintPermutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str = in.next();
		printPermutations(str, "");
		in.close();
	}

	public static void printPermutations(String str, String asf) {

		if (str.length() == 0) {
			System.out.println(asf);
			return;
		}
		
		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);
			String asf_new = asf + ch;
			String ros = str.substring(0, i) + str.substring(i + 1);

			printPermutations(ros, asf_new);
		}
		
		/* Or this can be done
		 
		 	//taking character
			char ch = str.charAt(i);
			
			//removing that character from string
			StringBuilder sb = new StringBuilder(str);
			sb.deleteCharAt(i);
			
			printPermutations(sb.toString(), asf + ch);
		 
		 */
		
		/* Or Use this to remove that character
		  
			String before_ch  = str.substring(0, i);
			String after_ch = str.substring(i+1);
			String next = before_ch + after_ch;
			printPermutations(next, asf + ch);
		*/
		
		
	}
}
