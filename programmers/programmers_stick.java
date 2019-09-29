package boj;

import java.util.Stack;

public class programmers_stick {
	public static void main(String[] args) {
		String arrangement = "()(((()())(())()))(())";

		int count = solution(arrangement);

		System.out.println(count);
	}

	public static int solution(String arrangement) {
		int answer = 0;

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < arrangement.length(); i++) {
			char bracket = arrangement.charAt(i);

			if (bracket == '(') {
				stack.push(bracket);
			} else {
				// bracket == ')'
				if (arrangement.charAt(i - 1) == '(') {
					stack.pop();
					answer += stack.size();
				} else {
					stack.pop();
					answer += 1;
				}
			}
		}

		return answer;
	}
}
