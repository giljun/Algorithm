import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_17070 {

	static int n;
	static int[][] map;
	static int count;

	// 가로, 세로, 대각선
	static int[] dx = { 0, 1, 1, 1, 0, 1, 1 };
	static int[] dy = { 1, 1, 0, 1, 1, 1, 0 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// Pipe 객체 생성
		Pipe pi = new Pipe(0, 0, 0, 1, 0);
		count = 0;
		
		move(pi);
		
		System.out.println(count);
	}

	private static void move(Pipe pi) {
		if (pi.hx == n-1 && pi.hy == n-1) {
			count++;
			return;
		}

		if (pi.state == 0) {
			// 가로
			for (int i = 0; i < 2; i++) {
				int nx = pi.hx + dx[i];
				int ny = pi.hy + dy[i];
				if( i == 0 ) {
					if( nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 0) {
						Pipe p = new Pipe(pi.hx, pi.hy, nx, ny, 0);
						move(p);
					}
				}else {
					if( nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 0 && map[nx-1][ny] == 0 && map[nx][ny-1] == 0) {
						Pipe p = new Pipe(pi.hx, pi.hy, nx, ny, 2);
						move(p);
					}
				}
			}
		} else if (pi.state == 1) {
			// 세로
			for (int i = 2; i < 4; i++) {
				int nx = pi.hx + dx[i];
				int ny = pi.hy + dy[i];
				if( i == 2 ) {
					if( nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 0) {
						Pipe p = new Pipe(pi.hx, pi.hy, nx, ny, 1);
						move(p);
					}
				}else {
					if( nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 0 && map[nx-1][ny] == 0 && map[nx][ny-1] == 0) {
						Pipe p = new Pipe(pi.hx, pi.hy, nx, ny, 2);
						move(p);
					}
				}
			}
		} else if (pi.state == 2) {
			// 대각선
			for (int i = 4; i < 7; i++) {
				int nx = pi.hx + dx[i];
				int ny = pi.hy + dy[i];
				if( i == 4 ) {
					if( nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 0) {
						Pipe p = new Pipe(pi.hx, pi.hy, nx, ny, 0);
						move(p);
					}
				}else if(i == 5){
					if( nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 0 && map[nx-1][ny] == 0 && map[nx][ny-1] == 0) {
						Pipe p = new Pipe(pi.hx, pi.hy, nx, ny, 2);
						move(p);
					}
				}else {
					if( nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 0) {
						Pipe p = new Pipe(pi.hx, pi.hy, nx, ny, 1);
						move(p);
					}
				}
			}
		} 
	}

	private static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	static class Pipe {
		int tx;
		int ty;
		int hx;
		int hy;
		int state;

		Pipe(int tx, int ty, int hx, int hy, int s) {
			this.tx = tx;
			this.ty = ty;
			this.hx = hx;
			this.hy = hy;
			this.state = s;
		}
	}
}