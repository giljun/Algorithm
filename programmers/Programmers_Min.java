import java.util.Arrays;

class Programmers_Min {

	public static void main(String args[]) {
		int[] A = { 1, 4, 2 };
		int[] B = { 5, 4, 4 };

		int result = solution(A, B);

		System.out.println(result);
	}

	public static int solution(int[] A, int[] B) {
		int answer = 0;

		Arrays.sort(A);
		Arrays.sort(B);

		int[] temp = new int[B.length];
		for (int i = B.length - 1; i >= 0; i--) {
			temp[B.length - 1 - i] = B[i];
			answer += (temp[B.length - 1 - i] * A[A.length - 1 - i]);
		}

		return answer;
	}
}