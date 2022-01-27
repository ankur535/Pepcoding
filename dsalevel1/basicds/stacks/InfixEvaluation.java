package dsalevel1.basicds.stacks;

import java.io.*;
import java.util.*;

public class InfixEvaluation {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String exp = br.readLine();
		System.out.println(evaluate(exp));
		// code
	}

	public static int evaluate(String exp) {

		Stack<Integer> operands = new Stack<>();
		Stack<Character> operators = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {

			char ch = exp.charAt(i);

			if (ch == '(') {
				operators.push(ch);
			} else if (ch >= '0' && ch <= '9') {
				operands.push(ch - '0');
			} else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				// if + or - comes after *,/,+ or -, do calculation
				// if * or / comes after +, -, don't do but
				// if * or / comes after * or /, do calculation
				while (operators.size() > 0 && prec(ch) <= prec(operators.peek())) {

					int opd2 = operands.pop();
					int opd1 = operands.pop();

					char op = operators.pop();

					int res = calculate(opd1, opd2, op);
					operands.push(res);
				}
				operators.push(ch);
			} else if (ch == ')') {
				// until reach '(' do calculation
				while (operators.peek() != '(') {
					int opd2 = operands.pop();
					int opd1 = operands.pop();

					char op = operators.pop();

					int res = calculate(opd1, opd2, op);
					operands.push(res);
				}
				operators.pop();
			}
		}
		// do calculation until operator stack is completely empty
		while (operators.size() > 0) {
			int opd2 = operands.pop();
			int opd1 = operands.pop();

			char op = operators.pop();

			int res = calculate(opd1, opd2, op);
			operands.push(res);
		}
		
		return operands.peek();
	}
	
	public static int calculate (int opd1, int opd2, char op) {
		
		if (op == '*') {
			return opd1*opd2;
		} else if (op == '/') {
			return opd1/opd2;
		} else if (op == '+') {
			return opd1 + opd2;
		} else {
			return opd1 - opd2;
		}
	}

	public static int prec(char ch) {

		if (ch == '*' || ch == '/') {
			return 2;
		} else if (ch == '+' || ch == '-') {
			return 1;
		}
		return 0;
	}

}
