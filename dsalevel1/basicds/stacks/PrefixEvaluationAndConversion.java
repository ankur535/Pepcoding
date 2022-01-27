package dsalevel1.basicds.stacks;

import java.io.*;
import java.util.*;

public class PrefixEvaluationAndConversion {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String exp = br.readLine();
		prefixEvaluationConversion(exp);
		// code
	}

	public static void prefixEvaluationConversion(String exp) {

		Stack<Integer> values = new Stack<>();
		Stack<String> infix = new Stack<>();
		Stack<String> postfix = new Stack<>();

		for (int i = exp.length() - 1; i >= 0; i--) {

			char ch = exp.charAt(i);
			
			if (ch == '*' || ch == '/' || ch == '+' || ch == '-') {
				
				int opd1 = values.pop();
				int opd2 = values.pop();
				
				int res = calculate(opd1, opd2, ch);
				values.push(res);
				
				String inf1 = infix.pop();
				String inf2 = infix.pop();
				
				String inf_res = "(" + inf1 + ch + inf2 + ")";
				infix.push(inf_res);
				
				String post1 = postfix.pop();
				String post2 = postfix.pop();
				
				String post_res = post1 + post2 + ch;
				postfix.push(post_res);
			} else {
				values.push(ch-'0');
				infix.push(ch+"");
				postfix.push(ch+"");
			}
		}
		System.out.println(values.peek());
		System.out.println(infix.peek());
		System.out.println(postfix.peek());
	}

	public static int calculate(int opd1, int opd2, char ch) {

		if (ch == '*') {
			return opd1 * opd2;
		} else if (ch == '/') {
			return opd1 / opd2;
		} else if (ch == '+') {
			return opd1 + opd2;
		} else {
			return opd1 - opd2;
		}
	}

}
