import java.util.Arrays;

public class kakao_secret {

	public static void main(String[] args) {
		int n = 16;
		int[] arr1 = { 0, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535,
				65535, 65535 };
		int[] arr2 = { 0, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535,
				65535, 65535 };

		Solution s = new Solution();

		String[] ans = s.solution(n, arr1, arr2);

		System.out.println(Arrays.toString(ans));
	}

}

class Solution {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];

		String first = "";
		String second = "";

		// 1. 첫번째 지도와 두번째 지도를 2진수로 변환한다.
		// 2. 두 지도를 합친다.
		// 3. 결과값에 저장한다.
		for (int i = 0; i < n; i++) {
			first = DecToBinary(arr1[i], n);
			second = DecToBinary(arr2[i], n);

			answer[i] = sum(first, second);
		}

		return answer;
	}

	public String DecToBinary(int num, int len) {
		String res = "";

		String tmp = "";
		while (num != 0) {
			if (num == 1) {
				res = 1 + res;
				break;
			}
			tmp = tmp + (num % 2);
			num = num / 2;
			res = tmp + res;

			tmp = "";
		}

		while (res.length() < len) {
			res = 0 + res;
		}

		return res;
	}

	public String sum(String first, String second) {
		String res = "";

		// first.length = second.length
		int len = first.length();
		for (int i = 0; i < len; i++) {
			if (first.charAt(i) == '1' || second.charAt(i) == '1') {
				res += "#";
			} else {
				res += " ";
			}
		}

		return res;
	}
}