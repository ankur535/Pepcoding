package dsalevel1.basicds.stacks;

import java.util.*;

public class BalancedBrackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String exp = in.nextLine();
		System.out.println(isBalancedBrackets(exp));
		in.close();
	}

	public static boolean isBalancedBrackets(String exp) {

		Stack<Character> st = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {

			char ch = exp.charAt(i);

			if (ch == '(' || ch == '[' || ch == '{') {
				st.push(ch);
			} else if (ch == ')') {
				if (st.size() == 0 || st.peek() != '(') {
					return false;
				}
				st.pop();
			} else if (ch == ']') {
				if (st.size() == 0 || st.peek() != '[') {
					return false;
				}
				st.pop();
			} else if (ch == '}') {
				if (st.size() == 0 || st.peek() != '{') {
					return false;
				}
				st.pop();
			}
		}

		// if stack size if not empty means left some empty brackets
		if (st.size() != 0) {
			return false;
		}

		return true;

	}

}
