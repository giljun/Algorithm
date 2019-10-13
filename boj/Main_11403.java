package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11403 {

	static int N;
	static int[][] Matrix;
	static boolean[] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		Matrix = new int[N][N];

		for (int i = 0; i < Matrix.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < Matrix.length; j++) {
				Matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < Matrix.length; i++) {
			isVisited = new boolean[N];
			for (int j = 0; j < Matrix.length; j++) {
				if (Matrix[i][j] == 1 && !isVisited[j]) {
					bfs(i, j);
				}
			}
		}
		
		print();
	}

	private static void print() {
		for (int i = 0; i < Matrix.length; i++) {
			for (int j = 0; j < Matrix.length; j++) {
				System.out.print(Matrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void bfs(int i, int j) {
		Queue<Integer> q = new LinkedList<>();

		q.add(j);

		while (!q.isEmpty()) {
			int node = q.poll();

			for (int k = 0; k < Matrix.length; k++) {
				if (Matrix[node][k] == 1 && !isVisited[k]) {
					q.add(k);
					Matrix[i][k] = 1;
					isVisited[k] = true;
				}
			}
		}
	}

}
