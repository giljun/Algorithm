import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int R, C, T;
	static int[][] house;
	static Point top, bottom;

	// 상, 좌, 하, 우
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	// 시계방향, 반시계 방향
	static int[] ccw = { 3, 0, 1, 2 };
	static int[] cw = { 3, 2, 1, 0 };
	
	static int res;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		house = new int[R][C];

		top = new Point(-1, -1);
		bottom = new Point(-1, -1);
		// -1 : 공기청정기가 설치된 공간.

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
				if (house[i][j] == -1) {
					if (top.x == -1) {
						top.x = j;
						top.y = i;
					} else {
						bottom.x = j;
						bottom.y = i;
					}
				}
			}
		}

		// 주어진 시간동안 미세먼지가 확산되고 공기청정기가 작동한다.
		for (int i = 0; i < T; i++) {
			// 1. 미세먼지가 확산된다.
			spreadDust();

			// 2. 공기청정기가 작동된다.( top : 반시계, bottom : 시계방향 )
			circulate(1, top);
			circulate(-1, bottom);
		}

		calculate();
		
		System.out.println(res);
	}

	static void circulate(int dir, Point air_cleaner) {
		int r = air_cleaner.y;
		int c = air_cleaner.x + 1;

		int curr = house[r][c];
		int next = 0;
		
		house[r][c] = 0;

		// 1인 경우, 반시계
		if (dir == 1) {
			for (int i = 0; i < 4; i++) {
				while (true) {
					int nextR = r + dy[ccw[i]];
					int nextC = c + dx[ccw[i]];
					
					// 1. 미세먼지가 집의 경계 밖으로 벗어나게 된다면, 방향을 바뀌어주어야한다.
					if (!(0 <= nextR && nextR < R && 0 <= nextC && nextC < C)) {
						break;
					}

					// 2. 공기청정기로 들어간 미세먼지는 정화된다.
					if (nextR == air_cleaner.y && nextC == air_cleaner.x) {
						break;
					}
					
					// 3. 위의 조건들을 모두 통과한 경우, +1만큼 반시계 방향으로 미세먼지가 이동함.
					next = house[nextR][nextC];
					house[nextR][nextC] = curr;
					curr = next;
					
					r = nextR;
					c = nextC;
				}
			}
		} else { // 시계방향
			for (int i = 0; i < 4; i++) {
				while (true) {
					int nextR = r + dy[cw[i]];
					int nextC = c + dx[cw[i]];
					
					// 1. 미세먼지가 집의 경계 밖으로 벗어나게 된다면, 방향을 바뀌어주어야한다.
					if (!(0 <= nextR && nextR < R && 0 <= nextC && nextC < C)) {
						break;
					}

					// 2. 공기청정기로 들어간 미세먼지는 정화된다.
					if (nextR == air_cleaner.y && nextC == air_cleaner.x) {
						break;
					}
					
					// 3. 위의 조건들을 모두 통과한 경우, +1만큼 반시계 방향으로 미세먼지가 이동함.
					next = house[nextR][nextC];
					house[nextR][nextC] = curr;
					curr = next;
					
					r = nextR;
					c = nextC;
				}
			}
		}
	}

	static void spreadDust() {
		// 현재, 존재하는 미세먼지에 대해서만 확산작업을 수행해야한다
		// 따라서, 현재 존재하는 미세먼지에 대해서 체크를 하는 배열을 하나 만든다.
		ArrayList<Dust> existDust = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (house[i][j] != -1 && house[i][j] != 0) {
					existDust.add(new Dust(i, j, house[i][j]));
//					System.out.println(i + " " + j);
				}
			}
		}

		// 현존하는 미세먼지에 대해서만 확산을 시작한다.
		for (int i = 0; i < existDust.size(); i++) {
			int r = existDust.get(i).r;
			int c = existDust.get(i).c;
			int n = existDust.get(i).n;
			int cnt = 0;

			// 4방향으로 확산을 시작한다.
			// 확산된 횟수에 대해 +1을 증가시켜준다.
			for (int j = 0; j < 4; j++) {
				if (r + dy[j] >= 0 && r + dy[j] < R && c + dx[j] >= 0 && c + dx[j] < C
						&& house[r + dy[j]][c + dx[j]] != -1) {
					house[r + dy[j]][c + dx[j]] += (n / 5);
					cnt++;
				}
			}
			house[r][c] -= (n / 5 * cnt);
		}
	}

	static void calculate() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(house[i][j]!=-1) {
					res += house[i][j];
				}
			}
		}
	}

	static class Dust {
		int r;
		int c;
		int n;

		public Dust(int r, int c, int n) {
			this.r = r;
			this.c = c;
			this.n = n;
		}
	}
}
