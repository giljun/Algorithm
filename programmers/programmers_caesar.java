package programmers;

public class programmers_caesar {

	public static void main(String[] args) {
		String s = "a B z";
		int n = 4;

		String answer = solution(s, n);

		System.out.println(answer);
	}

	public static String solution(String s, int n) {
		String answer = "";

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch >= 'a' && ch <= 'z') {
				// 소문자
				if (ch + n >= 'z') {
					ch = (char)(ch+(-26 + n));
				} else {
					ch = (char) (ch + n);
				}
			} else if (ch >= 'A' && ch <= 'Z') {
				// 대문자
				if (ch + n >= 'Z') {
					ch = (char)(ch+(-26 + n));
				} else {
					ch = (char) (ch + n);
				}
			}
			answer += ch;
		}
		return answer;
	}
}
