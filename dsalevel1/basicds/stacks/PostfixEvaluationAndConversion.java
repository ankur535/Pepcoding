package dsalevel1.basicds.stacks;

import java.io.*;
import java.util.*;

public class PostfixEvaluationAndConversion {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String exp = br.readLine();
		postfixEvaluatioConversion(exp);
		// code
	}

	public static void postfixEvaluatioConversion(String exp) {

		Stack<Integer> values = new Stack<>();
		Stack<String> infix = new Stack<>();
		Stack<String> prefix = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {

			char ch = exp.charAt(i);

			if (ch >= '0' && ch <= '9') {
				values.push(ch - '0');
				infix.push(ch + "");
				prefix.push(ch + "");
			} else if (ch == '*' || ch == '/' || ch == '+' || ch == '-') {

				int opd2 = values.pop();
				int opd1 = values.pop();

				int res = calculate(opd1, opd2, ch);
				values.push(res);

				String inf2 = infix.pop();
				String inf1 = infix.pop();

				String inf_res = "(" + inf1 + ch + inf2 + ")";
				infix.push(inf_res);

				String pre2 = prefix.pop();
				String pre1 = prefix.pop();

				String pre_res = ch + pre1 + pre2;
				prefix.push(pre_res);
			}
		}
		
		System.out.println(values.peek());
		System.out.println(infix.peek());
		System.out.println(prefix.peek());
	}
	
	public static int calculate (int opd1, int opd2, char ch) {
		
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
