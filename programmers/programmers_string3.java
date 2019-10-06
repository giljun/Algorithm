package programmers;

public class programmers_string3 {

	public static void main(String[] args) {
		String s ="1234";
		
		boolean answer = solution(s);
		
		System.out.println(answer);
	}

	public static boolean solution(String s) {
		boolean answer = true;

		// 문자열 길이 확인
		if(s.length()==4||s.length()==6) {
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if(ch >= 48 && ch <= 57) {
					continue;
				}else {
					answer = false;
					break;
				}
			}
		}else {
			answer = false;
		}

		return answer;
	}

}
