
class Programmers_bill {

	public static void main(String args[]) {
		int day = 6;

		int k = 1;

		int[] ans = solution(day, k);

		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i]+" ");
		}
	}

	private static int[] solution(int day, int k) {
		int[] ans = {};

		int[] month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		ans = new int[month.length];

		for (int i = 0; i < month.length; i++) {
			for (int j = 1; j <= month[i]; j++) {
				if (j == k) {
					if (day == 5 || day == 6) {
						ans[i] = 1;
					}
				}
				if (day == 6) {
					day = 0;
				} else {
					day++;
				}
			}

		}
		return ans;
	}

}