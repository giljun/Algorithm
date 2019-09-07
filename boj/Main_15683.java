package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15683 {

	static int N, M;
	static int[][] map;
	static boolean[][] isscan;
	static int safe_section;
	static int blind_spot;
	static int min;
	static ArrayList<CCTV> cctvs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		safe_section = 0;
		blind_spot = 0;
		min = Integer.MAX_VALUE;
		cctvs = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					safe_section++;
				} else if (map[i][j] != 6) {
					cctvs.add(new CCTV(i, j, map[i][j], 0));
				}
			}
		}

		// 완탐 시작
		dfs(0, cctvs);

		System.out.println(min);
	}

	private static void dfs(int i, ArrayList<CCTV> c) {
		if (i == cctvs.size()) {
			int cnt = 0;
			cnt = calc(c, map);
			if (min > safe_section - cnt) {
				min = safe_section - cnt;
			}
			return;
		}

		if (c.get(i).num == 1 || c.get(i).num == 3 || c.get(i).num == 4) {
			for (int j = 0; j < 4; j++) {
				c.get(i).dir = j;
				dfs(i + 1, c);
			}
		} else if (c.get(i).num == 2) {
			for (int j = 0; j < 2; j++) {
				c.get(i).dir = j;
				dfs(i + 1, c);
			}
		} else {
			dfs(i + 1, c);
		}
	}

	private static int calc(ArrayList<CCTV> c, int[][] m) {
		int cnt = 0;
		isscan = new boolean[N][M];

		for (int i = 0; i < c.size(); i++) {
			CCTV cv = c.get(i);
			if (cv.num == 1) {
				if (cv.dir == 0) {
					// 상
					for (int j = cv.x - 1; j >= 0; j--) {
						if (m[j][cv.y] == 6) {
							break;
						}
						if (m[j][cv.y] == 0 && !isscan[j][cv.y]) {
							isscan[j][cv.y] = true;
							cnt++;
						}
					}
				} else if (cv.dir == 1) {
					// 우
					for (int j = cv.y + 1; j < M; j++) {
						if (m[cv.x][j] == 6) {
							break;
						}
						if (m[cv.x][j] == 0 && !isscan[cv.x][j]) {
							isscan[cv.x][j] = true;
							cnt++;
						}
					}
				} else if (cv.dir == 2) {
					// 하
					for (int j = cv.x + 1; j < N; j++) {
						if (m[j][cv.y] == 6) {
							break;
						}
						if (m[j][cv.y] == 0 && !isscan[j][cv.y]) {
							isscan[j][cv.y] = true;
							cnt++;
						}
					}
				} else {
					// 좌
					for (int j = cv.y - 1; j >= 0; j--) {
						if (m[cv.x][j] == 6) {
							break;
						}
						if (m[cv.x][j] == 0 && !isscan[cv.x][j]) {
							isscan[cv.x][j] = true;
							cnt++;
						}
					}
				}
			} else if (cv.num == 2) {
				if (cv.dir == 0) {
					// 우
					for (int j = cv.y + 1; j < M; j++) {
						if (m[cv.x][j] == 6) {
							break;
						}
						if (m[cv.x][j] == 0 && !isscan[cv.x][j]) {
							isscan[cv.x][j] = true;
							cnt++;
						}
					}
					// 좌
					for (int j = cv.y - 1; j >= 0; j--) {
						if (m[cv.x][j] == 6) {
							break;
						}
						if (m[cv.x][j] == 0 && !isscan[cv.x][j]) {
							isscan[cv.x][j] = true;
							cnt++;
						}
					}
				} else if (cv.dir == 1) {
					// 상
					for (int j = cv.x - 1; j >= 0; j--) {
						if (m[j][cv.y] == 6) {
							break;
						}
						if (m[j][cv.y] == 0 && !isscan[j][cv.y]) {
							isscan[j][cv.y] = true;
							cnt++;
						}
					}
					// 하
					for (int j = cv.x + 1; j < N; j++) {
						if (m[j][cv.y] == 6) {
							break;
						}
						if (m[j][cv.y] == 0 && !isscan[j][cv.y]) {
							isscan[j][cv.y] = true;
							cnt++;
						}
					}
				}
			} else if (cv.num == 3) {
				if (cv.dir == 0) {
					// 상
					for (int j = cv.x - 1; j >= 0; j--) {
						if (m[j][cv.y] == 6) {
							break;
						}
						if (m[j][cv.y] == 0 && !isscan[j][cv.y]) {
							isscan[j][cv.y] = true;
							cnt++;
						}
					}
					// 우
					for (int j = cv.y + 1; j < M; j++) {
						if (m[cv.x][j] == 6) {
							break;
						}
						if (m[cv.x][j] == 0 && !isscan[cv.x][j]) {
							isscan[cv.x][j] = true;
							cnt++;
						}
					}
				} else if (cv.dir == 1) {
					// 우
					for (int j = cv.y + 1; j < M; j++) {
						if (m[cv.x][j] == 6) {
							break;
						}
						if (m[cv.x][j] == 0 && !isscan[cv.x][j]) {
							isscan[cv.x][j] = true;
							cnt++;
						}
					}
					// 하
					for (int j = cv.x + 1; j < N; j++) {
						if (m[j][cv.y] == 6) {
							break;
						}
						if (m[j][cv.y] == 0 && !isscan[j][cv.y]) {
							isscan[j][cv.y] = true;
							cnt++;
						}
					}
				} else if (cv.dir == 2) {
					// 하
					for (int j = cv.x + 1; j < N; j++) {
						if (m[j][cv.y] == 6) {
							break;
						}
						if (m[j][cv.y] == 0 && !isscan[j][cv.y]) {
							isscan[j][cv.y] = true;
							cnt++;
						}
					}
					// 좌
					for (int j = cv.y - 1; j >= 0; j--) {
						if (m[cv.x][j] == 6) {
							break;
						}
						if (m[cv.x][j] == 0 && !isscan[cv.x][j]) {
							isscan[cv.x][j] = true;
							cnt++;
						}
					}
				} else {
					// 좌
					for (int j = cv.y - 1; j >= 0; j--) {
						if (m[cv.x][j] == 6) {
							break;
						}
						if (m[cv.x][j] == 0 && !isscan[cv.x][j]) {
							isscan[cv.x][j] = true;
							cnt++;
						}
					}
					// 상
					for (int j = cv.x - 1; j >= 0; j--) {
						if (m[j][cv.y] == 6) {
							break;
						}
						if (m[j][cv.y] == 0 && !isscan[j][cv.y]) {
							isscan[j][cv.y] = true;
							cnt++;
						}
					}
				}
			} else if (cv.num == 4) {
				if (cv.dir == 0) {
					// 좌
					for (int j = cv.y - 1; j >= 0; j--) {
						if (m[cv.x][j] == 6) {
							break;
						}
						if (m[cv.x][j] == 0 && !isscan[cv.x][j]) {
							isscan[cv.x][j] = true;
							cnt++;
						}
					}
					// 상
					for (int j = cv.x - 1; j >= 0; j--) {
						if (m[j][cv.y] == 6) {
							break;
						}
						if (m[j][cv.y] == 0 && !isscan[j][cv.y]) {
							isscan[j][cv.y] = true;
							cnt++;
						}
					}
					// 우
					for (int j = cv.y + 1; j < M; j++) {
						if (m[cv.x][j] == 6) {
							break;
						}
						if (m[cv.x][j] == 0 && !isscan[cv.x][j]) {
							isscan[cv.x][j] = true;
							cnt++;
						}
					}
				} else if (cv.dir == 1) {
					// 상
					for (int j = cv.x - 1; j >= 0; j--) {
						if (m[j][cv.y] == 6) {
							break;
						}
						if (m[j][cv.y] == 0 && !isscan[j][cv.y]) {
							isscan[j][cv.y] = true;
							cnt++;
						}
					}
					// 우
					for (int j = cv.y + 1; j < M; j++) {
						if (m[cv.x][j] == 6) {
							break;
						}
						if (m[cv.x][j] == 0 && !isscan[cv.x][j]) {
							isscan[cv.x][j] = true;
							cnt++;
						}
					}
					// 하
					for (int j = cv.x + 1; j < N; j++) {
						if (m[j][cv.y] == 6) {
							break;
						}
						if (m[j][cv.y] == 0 && !isscan[j][cv.y]) {
							isscan[j][cv.y] = true;
							cnt++;
						}
					}
				} else if (cv.dir == 2) {
					// 우
					for (int j = cv.y + 1; j < M; j++) {
						if (m[cv.x][j] == 6) {
							break;
						}
						if (m[cv.x][j] == 0 && !isscan[cv.x][j]) {
							isscan[cv.x][j] = true;
							cnt++;
						}
					}
					// 하
					for (int j = cv.x + 1; j < N; j++) {
						if (m[j][cv.y] == 6) {
							break;
						}
						if (m[j][cv.y] == 0 && !isscan[j][cv.y]) {
							isscan[j][cv.y] = true;
							cnt++;
						}
					}
					// 좌
					for (int j = cv.y - 1; j >= 0; j--) {
						if (m[cv.x][j] == 6) {
							break;
						}
						if (m[cv.x][j] == 0 && !isscan[cv.x][j]) {
							isscan[cv.x][j] = true;
							cnt++;
						}
					}
				} else {
					// 하
					for (int j = cv.x + 1; j < N; j++) {
						if (m[j][cv.y] == 6) {
							break;
						}
						if (m[j][cv.y] == 0 && !isscan[j][cv.y]) {
							isscan[j][cv.y] = true;
							cnt++;
						}
					}
					// 좌
					for (int j = cv.y - 1; j >= 0; j--) {
						if (m[cv.x][j] == 6) {
							break;
						}
						if (m[cv.x][j] == 0 && !isscan[cv.x][j]) {
							isscan[cv.x][j] = true;
							cnt++;
						}
					}
					// 상
					for (int j = cv.x - 1; j >= 0; j--) {
						if (m[j][cv.y] == 6) {
							break;
						}
						if (m[j][cv.y] == 0 && !isscan[j][cv.y]) {
							isscan[j][cv.y] = true;
							cnt++;
						}
					}
				}
			} else {
				// 좌
				for (int j = cv.y - 1; j >= 0; j--) {
					if (m[cv.x][j] == 6) {
						break;
					}
					if (m[cv.x][j] == 0 && !isscan[cv.x][j]) {
						isscan[cv.x][j] = true;
						cnt++;
					}
				}
				// 상
				for (int j = cv.x - 1; j >= 0; j--) {
					if (m[j][cv.y] == 6) {
						break;
					}
					if (m[j][cv.y] == 0 && !isscan[j][cv.y]) {
						isscan[j][cv.y] = true;
						cnt++;
					}
				}
				// 우
				for (int j = cv.y + 1; j < M; j++) {
					if (m[cv.x][j] == 6) {
						break;
					}
					if (m[cv.x][j] == 0 && !isscan[cv.x][j]) {
						isscan[cv.x][j] = true;
						cnt++;
					}
				}
				// 하
				for (int j = cv.x + 1; j < N; j++) {
					if (m[j][cv.y] == 6) {
						break;
					}
					if (m[j][cv.y] == 0 && !isscan[j][cv.y]) {
						isscan[j][cv.y] = true;
						cnt++;
					}
				}
			}
		}

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(m[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("현재 감시 중인 영역의 수 : "+cnt);

		return cnt;
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("현재 안전 영역 : " + safe_section);
		for (int i = 0; i < cctvs.size(); i++) {
			System.out.print("cctv 번호 : " + cctvs.get(i).num);
		}
		System.out.println();
	}

	static class CCTV {
		int x;
		int y;
		int num;
		int dir;

		CCTV(int x, int y, int n, int d) {
			this.x = x;
			this.y = y;
			this.num = n;
			this.dir = d;
		}
	}
}
