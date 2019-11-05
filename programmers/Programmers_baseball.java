
class Programmers_baseball {

	static int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	static boolean[] isvisited = new boolean[numbers.length];
	static int count;

	public static void main(String args[]) {
		int[][] baseball = { { 123, 1, 1 }, { 356, 1, 0 }, { 327, 2, 0 }, { 489, 0, 1 } };
		
		int ans = solution(baseball);
	}

	public static int solution(int[][] baseball) {
		int answer = 0;
		
		count = 0;
		int[] b_num = new int[3];
		// 조합시작
		dfs(0, 3, baseball, b_num);

		return answer;
	}

	private static void dfs(int n, int r, int[][] baseball, int[] b_num) {
		if( n == r ) {
			int strike = 0;
			int ball = 0;
			for (int i = 0; i < baseball.length; i++) {
				
				for (int j = 0; j < b_num.length; j++) {
					
				}
			}
		}
		
		for (int i = 0; i < baseball.length; i++) {
			if(!isvisited[i]) {
				isvisited[i] = true;
				b_num[n] = numbers[i];
				dfs(n+1, r, baseball, b_num);
				isvisited[i] = false;
			}
		}

	}
}