package dsalevel1.basicds.stacks;

import java.io.*;
import java.util.*;

public class InfixConversion {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String exp = br.readLine();
		printPrePostfix(exp);
		// code
	}

	public static void printPrePostfix(String exp) {

		Stack<String> prefix = new Stack<>();
		Stack<String> postfix = new Stack<>();
		Stack<Character> operators = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {

			char ch = exp.charAt(i);

			if (ch == '(') {
				operators.push(ch);
			} else if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z')) {
				prefix.push(ch + "");
				postfix.push(ch + "");
			} else if (ch == '*' || ch == '/' || ch == '+' || ch == '-') {

				while (operators.size() > 0 && prec(ch) <= prec(operators.peek())) {

					char op = operators.pop();

					String pre2 = prefix.pop();
					String pre1 = prefix.pop();

					String pre_res = op + pre1 + pre2;
					prefix.push(pre_res);

					String post2 = postfix.pop();
					String post1 = postfix.pop();

					String post_res = post1 + post2 + op;
					postfix.push(post_res);
				}
				operators.push(ch);

			} else if (ch == ')') {
				while (operators.peek() != '(') {

					char op = operators.pop();

					String pre2 = prefix.pop();
					String pre1 = prefix.pop();

					String pre_res = op + pre1 + pre2;
					prefix.push(pre_res);

					String post2 = postfix.pop();
					String post1 = postfix.pop();

					String post_res = post1 + post2 + op;
					postfix.push(post_res);
				}
				operators.pop();
			}
		}
		while (operators.size() > 0) {

			char op = operators.pop();

			String pre2 = prefix.pop();
			String pre1 = prefix.pop();

			String pre_res = op + pre1 + pre2;
			prefix.push(pre_res);

			String post2 = postfix.pop();
			String post1 = postfix.pop();

			String post_res = post1 + post2 + op;
			postfix.push(post_res);
		}

		System.out.println(postfix.peek());
		System.out.println(prefix.peek());
	}

	public static int prec(char op) {

		if (op == '*' || op == '/') {
			return 2;
		} else if (op == '+' || op == '-') {
			return 1;
		}
		return 0;
	}

}
