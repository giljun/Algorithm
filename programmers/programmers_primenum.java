import java.util.ArrayList;

public class programmers_primenum {

	public static void main(String[] args) {
		int n = 5;

		int answer = solution(n);

		System.out.println(answer);
	}

	public static int solution(int n) {

		ArrayList<Integer> prime = new ArrayList<>();

		boolean[] arr = new boolean[n + 1];
		arr[0] = arr[1] = false;
		for (int i = 2; i <= n; i++) {
			arr[i] = true;
		}

		for (int i = 2; i * i <= n; i++) {
			if (arr[i]) {
				for (int j = i * i; j <= n; j += i) {
					arr[j] = false;
				}
			}
		}

		for (int i = 0; i <= n; i++) {
			if (arr[i] == true) {
				prime.add(i);
			}
		}

		return prime.size();
	}
}
