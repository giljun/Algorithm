import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_13460 {

	static char[][] map;
	static Info start;
	static int[][][][] visited;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		start = new Info(0, 0, 0, 0, 0);

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'R') {
					start.rx = i;
					start.ry = j;
				}
				if (map[i][j] == 'B') {
					start.bx = i;
					start.by = j;
				}
			}
		}

		visited = new int[10][10][10][10];

		int res = bfs();
		
		System.out.println(res);
	}

	private static int bfs() {
		int res = -1;

		Queue<Info> q = new LinkedList<>();

		q.add(start);
		visited[start.rx][start.ry][start.bx][start.by] = 1;

		while (!q.isEmpty()) {
			Info cur = q.poll();

			if (cur.count > 10) {
				break;
			}

			if (map[cur.rx][cur.ry] == 'O' && map[cur.bx][cur.by] != 'O') {
				res = cur.count;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int next_rx = cur.rx;
				int next_ry = cur.ry;
				int next_bx = cur.bx;
				int next_by = cur.by;

				// 빨간 공 이동 시작
				while (true) {
					if (map[next_rx][next_ry] != '#' && map[next_rx][next_ry] != 'O') {
						next_rx += dx[i];
						next_ry += dy[i];
					} else {
						if (map[next_rx][next_ry] == '#') {
							next_rx -= dx[i];
							next_ry -= dy[i];
						}
						break;
					}
				}

				// 파란 공 이동 시작
				while (true) {
					if (map[next_bx][next_by] != '#' && map[next_bx][next_by] != 'O') {
						next_bx += dx[i];
						next_by += dy[i];
					} else {
						if (map[next_bx][next_by] == '#') {
							next_bx -= dx[i];
							next_by -= dy[i];
						}
						break;
					}
				}

				// 도착한 둘의 위치가 같을 경우
				if (next_rx == next_bx && next_ry == next_by) {
					if (map[next_rx][next_ry] != 'O') {
						int red_dist = Math.abs(next_rx - cur.rx) + Math.abs(next_ry - cur.ry);
						int blue_dist = Math.abs(next_bx - cur.bx) + Math.abs(next_by - cur.by);

						if (red_dist > blue_dist) {
							next_rx -= dx[i];
							next_ry -= dy[i];
						} else {
							next_bx -= dx[i];
							next_by -= dy[i];
						}
					}
				}

				// 왔던 곳은 되돌아 가지 않는다.
				if (visited[next_rx][next_ry][next_bx][next_by] == 0) {
					visited[next_rx][next_ry][next_bx][next_by] = 1;
					Info next = new Info(next_rx, next_ry, next_bx, next_by, cur.count + 1);
					q.add(next);
				}
			}
		}

		return res;
	}

	static class Info {
		int rx;
		int ry;
		int bx;
		int by;
		int count;

		public Info(int rx, int ry, int bx, int by, int c) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.count = c;
		}
	}
}