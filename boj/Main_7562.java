package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7562 {

	static int T;
	static int N;
	static int[][] Map;
	static boolean[][] isVisited;
	static Point start, end;

	static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			Map = new int[N][N];
			isVisited = new boolean[N][N];

			st = new StringTokenizer(br.readLine());
			start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			st = new StringTokenizer(br.readLine());
			end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			bfs(start.x, start.y);

			System.out.println(Map[end.x][end.y]);
		}

	}

	private static void bfs(int i, int j) {
		Queue<Point> q = new LinkedList<>();

		isVisited[i][j] = true;
		q.add(new Point(i, j));

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (p.x == end.x && p.y == end.y) {
				break;
			}

			for (int k = 0; k < 8; k++) {
				int nx = p.x + dx[k];
				int ny = p.y + dy[k];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !isVisited[nx][ny]) {
					q.add(new Point(nx, ny));
					isVisited[nx][ny] = true;
					Map[nx][ny] = Map[p.x][p.y] + 1;
				}
			}
		}
	}

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
