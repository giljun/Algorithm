package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2806 {

	static int[] cols;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			cols = new int[n];
			answer = 0;
			nQueen(n, 0);
			System.out.println("#" + tc + " " + answer);
		}
	}

	private static void nQueen(int n, int level) {
		if (level == n) {
			answer++;
			return;
		} else {
			for (int i = 0; i < n; i++) {
				cols[level] = i;
				if (isPossible(level)) {
					nQueen(n, level + 1);
				}
			}
		}
	}

	private static boolean isPossible(int level) {
		for (int i = 0; i < level; i++) {
			if (cols[i] == cols[level] || Math.abs(level - i) == Math.abs(cols[level] - cols[i])) {
				return false;
			}
		}
		return true;
	}

}
