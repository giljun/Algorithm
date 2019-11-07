import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_1065 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());
		int result = 0;
		int[] arr = new int[3]; // 1000���� �ۿ� ����.

		for (int i = 1; i <= n; i++) {
			// 1�ڸ�, 2�ڸ� ���� ��� �Ѽ��� �����Ѵ�.
			if (i < 100) {
				result++;
			} else {
				if (i == 1000) {
					break;
				}
				int index = 0;
				int temp = i;
				while (temp > 0) {
					arr[index] = temp % 10;
					temp /= 10;
					index++;
				}
				if ((arr[0] - arr[1]) == (arr[1] - arr[2])) {
					result++;
				}
			}
		}
		System.out.println(result);
	}
}