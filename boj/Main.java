import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

	static int n, m, d;
	static int[][] map;
	static boolean[] isarrange;
	static Archor[] archores;
	static int max;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		isarrange = new boolean[m];
		archores = new Archor[3];
		max = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 게임 시작
		gamestart();
	}

	private static void gamestart() {
		// 1. 궁수 배치
		dfs(0, 3);
	}

	private static void dfs(int depth, int e) {
		if (depth == e) {
			// 2. 궁수 배치 완료 이후, 공격 시작
			int count = attack();
			if (max < count) {
				max = count;
			}
			return;
		}
		for (int i = 0; i < isarrange.length; i++) {
			if (!isarrange[i]) {
				isarrange[i] = true;
				archores[depth] = new Archor(n, i);
				dfs(depth + 1, e);
				isarrange[i] = false;
			}
		}
	}

	private static int attack() {
		int count = 0;

		while (true) {
			if (isEmpty()) {
				break;
			}

			// 3. 공격 개시
			// 최종적으로 제거할 적에 대한 임시 변수
			ArrayList<Archor> enemies = new ArrayList<>();
			for (int i = 0; i < archores.length; i++) {
				int dist = 16;
				int left = 16;
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < m; k++) {
						// 적이 있다면,
						if (map[j][k] == 1) {
							// 사정거리가 더 짧은 지를 계산
							int di = Math.abs(archores[i].r - j) + Math.abs(archores[i].c - k);
							if(dist > di) {
								dist = di;
							}else if( dist == di) {
								if( left > k ) {
									left = k;
								}
							}
						}
					}
				}
				
			}

		}

		return count;
	}

	private static boolean isEmpty() {
		int count = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					count++;
				}
			}
		}
		if (count == 0) {
			return true;
		} else {
			return false;
		}
	}

	private static void print() {
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static class Archor {
		int r;
		int c;

		public Archor(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}