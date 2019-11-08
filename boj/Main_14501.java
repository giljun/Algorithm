import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_14501 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());

		int[][] schedule = new int[2][n + 6];
		int[] dp = new int[n + 6];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			schedule[0][i] = Integer.parseInt(st.nextToken());
			schedule[1][i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;

		for (int i = 1; i <= n + 1; i++) {
			int ti = schedule[0][i];
			int pi = schedule[1][i];
			dp[i] = Math.max(max, dp[i]);
			if (i + ti <= n + 1) {
				dp[i + ti] = Math.max(dp[i + ti], dp[i] + pi);
			}
			if (max < dp[i]) {
				max = dp[i];
			}
		}
        System.out.println(max);
	}
}