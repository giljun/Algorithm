
public class programmers_stock {

	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 2, 3 };

		int[] answer = solution(prices);

		print(answer);
	}

	private static void print(int[] answer) {
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}

	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		int cnt = 0;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[i] <= prices[j]) {
					cnt++;
				} else {
					cnt++;
					break;
				}
			}
			answer[i] = cnt;
			cnt = 0;
		}

		return answer;
	}
}
