import java.util.Arrays;
import java.util.Comparator;

class Programmers_hidx {

	public static void main(String args[]) {
		int[] citations = { 2, 2, 2 };

		int ans = solution(citations);

		System.out.println(ans);
	}

	public static int solution(int[] citations) {
		int answer = 0;

		Integer[] c = Arrays.stream(citations).boxed().toArray(Integer[]::new);

		Arrays.sort(c, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});

		int n = c.length;
		for (int i = 0; i < c[0] + 1; i++) {
			int h = i;

			if (h > n) {
				break;
			} else {
				int cnt = 0;
				for (int j = 0; j < c.length; j++) {
					if (h <= c[j]) {
						cnt++;
					}
				}
				if (cnt >= h) {
					if (answer < h) {
						answer = h;
					}
				}
			}
		}
		return answer;
	}
}