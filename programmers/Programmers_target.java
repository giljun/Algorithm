
class Programmers_target {

	static int count;

	public static void main(String args[]) {
		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;

		int result = solution(numbers, target);

		System.out.println(result);
	}

	public static int solution(int[] numbers, int target) {
		int answer = 0;

		boolean[] isvisited = new boolean[numbers.length];
		count = 0;

		dfs(numbers, isvisited, 0, numbers.length, target, 0);

		answer = count;
		return answer;
	}

	private static void dfs(int[] numbers, boolean[] isvisited, int depth, int r, int target, int sum) {
		if (depth == r) {
			if (sum == target) {
				count++;
			}
			return;
		}

		dfs(numbers, isvisited, depth + 1, r, target, sum + numbers[depth]);
		dfs(numbers, isvisited, depth + 1, r, target, sum - numbers[depth]);
	}
}