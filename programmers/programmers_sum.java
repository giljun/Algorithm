
public class programmers_sum {

	public static void main(String[] args) {
		int n = 123;
		
		int answer = solution(n);
		
		System.out.println(answer);
	}

	public static int solution(int n) {
        int answer = 0;
        
        String s = "";
        
        s += n;
        
        for (int i = 0; i < s.length(); i++) {
        	answer += (s.charAt(i)-48);
		}
        
        return answer;
    }
}
