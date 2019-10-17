import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main_17135 {

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

		System.out.println(max);
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
//			if(archores[0].c == 1 && archores[1].c == 2 &&archores[2].c == 3) {
//				int count = attack();
//				System.out.println(count);
//			}
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

		int[][] world = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				world[i][j] = map[i][j];
			}
		}

		while (true) {
			if (isEmpty(world)) {
				break;
			}

			// 3. 공격 개시
			// 최종적으로 제거할 적에 대한 임시 변수
			ArrayList<Archor> enemies = new ArrayList<>();
			for (int i = 0; i < archores.length; i++) {
				int ar = archores[i].r;
				int ac = archores[i].c;
				int distance = 16;

				int er = -1;
				int ec = -1;
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < m; k++) {
						if (world[j][k] == 1) {
							int dist = Math.abs(ar - j) + Math.abs(ac - k);
							if (dist <= d) {
								if (distance > dist) {
									distance = dist;
									er = j;
									ec = k;
								} else if (distance == dist) {
									if (ec > k) {
										er = j;
										ec = k;
									}
								}
							}
						}
					}
				}
				if (er != -1 && ec != -1) {
					enemies.add(new Archor(er, ec));
				}
			}

			// 4. 화살에 맞은 적들 제거
			for (int i = 0; i < enemies.size(); i++) {
				int er = enemies.get(i).r;
				int ec = enemies.get(i).c;

				if (world[er][ec] == 1) {
					count++;
					world[er][ec] = 0;
				}
			}

			// 5. 적들 한칸 앞 전진
			enemies = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (world[i][j] == 1) {
						enemies.add(new Archor(i, j));
					}
				}
			}

			for (int i = enemies.size() - 1; i >= 0; i--) {
				int er = enemies.get(i).r + 1;
				int ec = enemies.get(i).c;
				if (er == n) {
					world[er - 1][ec] = 0;
				} else {
					world[er - 1][ec] = 0;
					world[er][ec] = 1;
				}
			}

		}

		return count;
	}

	private static boolean isEmpty(int[][] world) {
		int count = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (world[i][j] == 1) {
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
		for (int i = 0; i < n; i++) {
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