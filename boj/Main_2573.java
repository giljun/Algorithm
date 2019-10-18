import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_2573 {

	static int n, m;
	static int[][] map;
	static int[][] mm;
	static boolean[][] visited;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int year = 0;
		while (true) {
			// 1. 빙산이 녹는다.
			meltMountain();
			// 2. 녹아있는 빙산 덩어리의 수를 센다.
			int count = numofMountain();
			// 3. 두 덩어리 이상인지를 체크하고,
			// 두 덩어리 이상으로 분리되지 않는다면 프로그램은 0을 출력한다.
			year++;
			if (count >= 2) {
				break;
			} else if (count == 0) {
				year = 0;
				break;
			}
		}

		System.out.println(year);
	}

	private static int numofMountain() {
		int count = 0;

		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					count++;
					bfs(i, j);
				}
			}
		}

		return count;
	}

	private static void bfs(int i, int j) {
		Queue<Ice> q = new LinkedList<>();

		q.add(new Ice(i, j));
		visited[i][j] = true;

		while (!q.isEmpty()) {
			Ice ice = q.poll();
			for (int k = 0; k < 4; k++) {
				int nr = ice.r + dx[k];
				int nc = ice.c + dy[k];
				if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && map[nr][nc] != 0) {
					visited[nr][nc] = true;
					q.add(new Ice(nr, nc));
				}
			}
		}
	}

	private static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void meltMountain() {
		mm = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0) {
					melt(i, j);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] - mm[i][j] > 0) {
					map[i][j] -= mm[i][j];
				} else {
					map[i][j] = 0;
				}
			}
		}
	}

	private static void melt(int i, int j) {
		for (int k = 0; k < 4; k++) {
			int ni = i + dx[k];
			int nj = j + dy[k];
			if (ni >= 0 && ni < n && nj >= 0 && nj < m && map[ni][nj] == 0) {
				mm[i][j]++;
			}
		}
	}

	static class Ice {
		int r;
		int c;

		public Ice(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}