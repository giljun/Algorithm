
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2875 {

	static int N, M, K;
	static int team;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = K; i > 0; i--) {
			if (N > (M * 2)) {
				N -= 1;
			} else {
				M -= 1;
			}
		}

		calc(N, M);

		System.out.println(team);
	}

	private static void calc(int n, int m) {
		for (int i = 0; i < M; i++) {
			if ((n - 2) >= 0) {
				n -= 2;
				m -= 1;
				team++;
			}
		}
	}

}
