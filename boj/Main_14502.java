import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] ispolleted;
	static int safe;
	static int virus;
	static ArrayList<Point> v;
	static Queue<Point> queue;
	static int max_safe;

	// 상 하 좌 우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		safe = -3;
		virus = 0;
		v = new ArrayList<>();
		max_safe = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					safe++;
				}
				if (map[i][j] == 2) {
					v.add(new Point(i, j));
				}
			}
		}
		
		makewall(0, 0, 0);
		
		System.out.println(max_safe);
	}

	private static void makewall(int i, int j, int w) {
		// 3개의 벽이 세워지면, 바이러스가 퍼진다.
		if (w == 3) {
			bfs();
			if( max_safe < safe - (virus))
			{
				max_safe = safe - (virus);
			}
			virus = 0;
			return;
		}

		for (int k = i; k < N; k++) {
			if( k != i ) {
				j = 0;
			}
			for (int l = j; l < M; l++) {
				if (map[k][l] == 0) {
					map[k][l] = 1;
					makewall(k, l+1, w + 1);
					map[k][l] = 0;
				}
			}
		}
	}

	private static void bfs() {
		ispolleted = new boolean[N][M];
		queue = new LinkedList<>();

		for (int i = 0; i < v.size(); i++) {
			Point vi = v.get(i);

			queue.add(vi);

			while (!queue.isEmpty()) {
				Point p = queue.poll();

				for (int j = 0; j < 4; j++) {
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];
					if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
						if (map[nx][ny] == 0 && !ispolleted[nx][ny]) {
							virus++;
							ispolleted[nx][ny] = true;
							queue.add(new Point(nx, ny));
						}
					}
				}
			}
		}
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}