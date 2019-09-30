package programmers;

public class BigNumber {
	static int max;

	public static void main(String[] args) {
		String number = "1924";
		int k = 2;

		String answer = solution(number, k);

		System.out.println(answer);
	}

	public static String solution(String number, int k) {
		StringBuilder answer = new StringBuilder();

		int idx = 0;
		char max = '0';

		if (number.charAt(0) == '0') {
			return "0";
		}

		int n = number.length() - k;
		for (int i = 0; i < n; i++) {
			max = '0';
			for (int j = idx; j <= k + i; j++) {
				if(max < number.charAt(j)) {
					max = number.charAt(j);
					idx = j+1;
				}
			}
			answer.append(max);
		}

		return answer.toString();
	}

}
