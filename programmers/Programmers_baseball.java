
class Programmers_baseball {

	static char[] numbers = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	static boolean[] isvisited = new boolean[numbers.length];
	static int count;

	public static void main(String args[]) {
		int[][] baseball = { { 123, 1, 1 }, { 356, 1, 0 }, { 327, 2, 0 }, { 489, 0, 1 } };

		int ans = solution(baseball);
		
		System.out.println(ans);
	}

	public static int solution(int[][] baseball) {
		int answer = 0;

		count = 0;
		char[] b_num = new char[3];
		// 조합시작
		dfs(0, 3, baseball, b_num);

		answer = count;
		
		return answer;
	}

	private static void dfs(int n, int r, int[][] baseball, char[] b_num) {
		if (n == r) {
			int strike = 0;
			int ball = 0;
			boolean isCorrect = true;
			String num = "";
			for (int i = 0; i < baseball.length; i++) {
				num += baseball[i][0];
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						if (j == k && num.charAt(j) == b_num[k]) {
							strike++;
						} else if (j != k && num.charAt(j) == b_num[k]) {
							ball++;
						}
					}
				}
				if (strike == baseball[i][1] && ball == baseball[i][2]) {
					isCorrect = true;
				}else {
					isCorrect = false;
					break;
				}
				num = "";
				strike = 0;
				ball = 0;
			}
			if(isCorrect) {
				count++;
			}
			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			if (!isvisited[i]) {
				isvisited[i] = true;
				b_num[n] = numbers[i];
				dfs(n + 1, r, baseball, b_num);
				isvisited[i] = false;
			}
		}
	}
}