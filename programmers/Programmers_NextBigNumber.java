
class Programmers_NextBigNumber {

	public static void main(String args[]) {
		int n = 78;

		int result = solution(n);

		System.out.println(result);
	}

	public static int solution(int n) {
		int answer = 0;

		int count = Integer.bitCount(n);

		while (true) {
			n++;
			if (count == Integer.bitCount(n)) {
				answer = n;
				break;
			}
		}
		return answer;
	}
}