package swexpert;

import java.io.IOException;

public class programmers_dfs {

	static int max;

	public static void main(String[] args) throws IOException {
		int[] v = { 20, 8, 10, 1, 4, 15 };

		int res = solution(v);

		System.out.println(max);
	}

	public static int solution(int[] v) {
		int answer = 0;

		int n = v.length;
		max = 0;
		boolean[] visited = new boolean[n];

		int[] res = new int[v.length];

		dfs(v, 0, n, visited, res);

		return max;
	}

	private static void dfs(int[] v, int d, int n, boolean[] visited, int[] res) {
		if (d == n) {
			int cnt = 0;
			for (int i = 0; i < res.length-1; i++) {
				cnt += Math.abs(res[i]-res[i+1]);
			}
			if( max < cnt) {
				max = cnt;
			}
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				res[d] = v[i];
				dfs(v, d+1, n, visited, res);
				visited[i] = false;
			}
		}
	}
}
