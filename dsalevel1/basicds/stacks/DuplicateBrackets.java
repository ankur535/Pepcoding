package dsalevel1.basicds.stacks;

import java.util.*;

public class DuplicateBrackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String exp = in.nextLine();
		System.out.println(isDuplicateBrackets(exp));
		in.close();
	}

	public static boolean isDuplicateBrackets(String exp) {

		Stack<Character> st = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);

			if (ch == ')') {
				if (st.peek() == '(') {
					return true;
				}
				while(st.peek() != '(') {
					st.pop();
				}
				//pop '(' bracket
				st.pop();
			} else {
				st.push(ch);
			}
		}
		return false;
	}

}
