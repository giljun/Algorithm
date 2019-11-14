import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503 {

	static int N, M;
	static Robot robot;
	static int[][] room;
	static boolean[][] isCleaned;

	static int[] north_dir = { -1, -1, 1, 1 };
	static int[] east_dir = { -1, 1, 1, -1 };
	static int[] south_dir = { 1, 1, -1, -1 };
	static int[] west_dir = { 1, -1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		robot = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()), 0, 0);

		room = new int[N][M];
		isCleaned = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean isstopped = false;
		while (!isstopped) {
			// 1. 현재 위치를 청소한다.
			isCleaned[robot.r][robot.c] = true;
			robot.count++;

			// 2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향을 기준으로 탐색을 진행한다.
			// 2.1. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전하고 한 칸을 전진하고 1번부터 진행한다.
			// 2.2. 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
			// 2.3. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진한 뒤, 2번으로 돌아간다.
			// 2.4. 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
			boolean isFind = false;
			while (!isFind) {
				if (robot.turn == 4) {
					// 2.3. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진한 뒤, 2번으로 돌아간다.
					robot.turn = 0;

					if (robot.d == 0) {
						int nr = robot.r + 1;
						int nc = robot.c;
						if (nr < N && room[nr][nc] == 0) {
							robot.r = nr;
							robot.c = nc;
						} else {
							isstopped = true;
							break;
						}
					} else if (robot.d == 1) {
						int nr = robot.r;
						int nc = robot.c - 1;
						if (nc >= 0 && room[nr][nc] == 0) {
							robot.r = nr;
							robot.c = nc;
						} else {
							isstopped = true;
							break;
						}
					} else if (robot.d == 2) {
						int nr = robot.r - 1;
						int nc = robot.c;
						if (nr >= 0 && room[nr][nc] == 0) {
							robot.r = nr;
							robot.c = nc;
						} else {
							isstopped = true;
							break;
						}
					} else {
						int nr = robot.r;
						int nc = robot.c + 1;
						if (nc < M && room[nr][nc] == 0) {
							robot.r = nr;
							robot.c = nc;
						} else {
							isstopped = true;
							break;
						}
					}
				}
				
				if (robot.d == 0) { // 북쪽 방향
					int nr = robot.r;
					int nc = robot.c - 1;
					if (nc >= 0 && nc < M && room[nr][nc] == 0 && !isCleaned[nr][nc]) {
						robot.d = 3;
						robot.r = nr;
						robot.c = nc;
						robot.turn = 0;
						isFind = true;
					} else {
						robot.d = 3;
						robot.turn++;
					}
				} else if (robot.d == 1) { // 동쪽 방향
					int nr = robot.r - 1;
					int nc = robot.c;
					if (nr >= 0 && nr < N && room[nr][nc] == 0 && !isCleaned[nr][nc]) {
						robot.d = 0;
						robot.r = nr;
						robot.c = nc;
						robot.turn = 0;
						isFind = true;
					} else {
						robot.d = 0;
						robot.turn++;
					}
				} else if (robot.d == 2) { // 남쪽 방향
					int nr = robot.r;
					int nc = robot.c + 1;
					if (nc >= 0 && nc < M && room[nr][nc] == 0 && !isCleaned[nr][nc]) {
						robot.d = 1;
						robot.r = nr;
						robot.c = nc;
						robot.turn = 0;
						isFind = true;
					} else {
						robot.d = 1;
						robot.turn++;
					}
				} else { // 서쪽 방향
					int nr = robot.r + 1;
					int nc = robot.c;
					if (nr >= 0 && nr < N && room[nr][nc] == 0 && !isCleaned[nr][nc]) {
						robot.d = 2;
						robot.r = nr;
						robot.c = nc;
						robot.turn = 0;
						isFind = true;
					} else {
						robot.d = 2;
						robot.turn++;
					}
				}
			}
		}

		System.out.println(robot.count);
	}

	static class Robot {
		int r;
		int c;
		int d;
		int count;
		int turn;

		Robot(int r, int c, int d, int cnt, int t) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.count = cnt;
			this.turn = t;
		}
	}
}
