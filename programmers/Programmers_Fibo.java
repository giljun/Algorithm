
class Programmers_Fibo {

	public static void main(String args[]) {
		int n = 3;

		int result = solution(n);

		System.out.println(result);
	}

	public static int solution(int n) {
		int answer = 0;

		long fibo = fibo(n);

		answer = (int) fibo;

		return answer;
	}

	private static long fibo(int n) {
		if (n <= 1) {
			return n;
		} else {
		    long[] fibo = new long[n + 1];
			fibo[0] = 0;
			fibo[1] = 1;
			for (int i = 2; i <= n; i++) {
				fibo[i] = fibo[i - 1] + fibo[i - 2];
				fibo[i] %= 1234567;
			}
			return fibo[n];
		}
	}
}