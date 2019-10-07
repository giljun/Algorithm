package programmers;

public class programmers_string4 {

	public static void main(String[] args) {
		String[] seoul = {"Jane", "Kim"};
		
		String answer = solution(seoul);
		
		System.out.println(answer);
	}

	public static String solution(String[] seoul) {
		String answer = "";
		
		int index = 0;
		for (int i = 0; i < seoul.length; i++) {
			if(seoul[i].equals("Kim")) {
				index = i;
				break;
			}
		}
		
		answer += "김서방은 "+index+"에 있다";
		
		return answer;
	}
}
