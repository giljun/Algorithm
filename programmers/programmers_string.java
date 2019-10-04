import java.util.Arrays;
import java.util.Comparator;

public class programmers_string {

	public static void main(String[] args) {
		String[] strings = {"abce", "abcd", "cdx"};
		int n = 1;
		
		String[] answer = solution(strings, n);
		
		print(answer);
	}

	private static void print(String[] answer) {
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i]+" ");
		}
		System.out.println();
	}

	public static String[] solution(String[] strings, int n) {
		String[] answer = {};
		
		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.charAt(n)==o2.charAt(n)) {
					return o1.compareTo(o2);
				}else {
					return o1.charAt(n)-o2.charAt(n);
				}
			}
		});
		
		answer = strings;
		
		return answer;
	}
}
