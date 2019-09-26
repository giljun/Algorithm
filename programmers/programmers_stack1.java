import java.util.ArrayList;

public class programmers_stack1 {

	public static void main(String[] args) {
		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };

		int[] ans = solution(progresses, speeds);

		print(ans);
	}

	private static void print(int[] ans) {
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};

		ArrayList<Integer> res = new ArrayList<>();

		int n = progresses.length;

		int[] time = new int[n];
		for (int i = 0; i < n; i++) {
			while (progresses[i] < 100) {
				progresses[i] += speeds[i];
				time[i]++;
			}
			System.out.print(time[i] + " ");
		}

		int cnt = 1;
		boolean[] check = new boolean[n];
		for (int i = 0; i < time.length; i++) {
			if (!check[i]) {
				check[i] = true;
				for (int j = i + 1; j < time.length; j++) {
					if (time[i] >= time[j]) {
						cnt++;
						check[j] = true;
					} else {
						break;
					}
				}
				res.add(cnt);
				cnt = 1;
			}
		}

		int len = res.size();
		answer = new int[len];
		for (int i = 0; i < res.size(); i++) {
			answer[i] = res.get(i);
		}

		return answer;
	}

	static class Service {
		int progress;
		int speed;

		public Service(int p, int s) {
			this.progress = p;
			this.speed = s;
		}
	}
}
