package boj;

import java.util.ArrayList;

public class programmers_chess {
	public static void main(String[] args) {
		String[] bishops = { "D5", "E8", "G2" };

		int max = solution(bishops);

		System.out.println(max);
	}

	public static int solution(String[] bishops) {
		int answer = 0;

		int[][] board = new int[8][8];

		ArrayList<Bishop> bis = new ArrayList<>();
		// 비숍의 위치를 게임판상의 좌표로 변환
		for (int i = 0; i < bishops.length; i++) {
			String bishop = bishops[i];
			bis.add(new Bishop(7-(bishop.charAt(1) - 49), bishop.charAt(0) - 65));
//			System.out.println(bis.get(i).x + " " + bis.get(i).y);
		}

		for (int i = 0; i < bis.size(); i++) {
			// 비숍 배치
			int x = bis.get(i).x;
			int y = bis.get(i).y;

			board[x][y] = 1;

			// 좌상
			int nx = bis.get(i).x - 1;
			int ny = bis.get(i).y - 1;
			while (nx >= 0 && ny >= 0) {
				board[nx][ny] = 1;
				nx -= 1;
				ny -= 1;
			}

			// 우상
			nx = bis.get(i).x - 1;
			ny = bis.get(i).y + 1;
			while (nx >= 0 && ny < board.length) {
				board[nx][ny] = 1;
				nx -= 1;
				ny += 1;
			}

			// 좌하
			nx = bis.get(i).x + 1;
			ny = bis.get(i).y - 1;
			while (nx < board.length && ny >= 0) {
				board[nx][ny] = 1;
				nx += 1;
				ny -= 1;
			}

			// 우하
			nx = bis.get(i).x + 1;
			ny = bis.get(i).y + 1;
			while (nx < board.length && ny < board.length) {
				board[nx][ny] = 1;
				nx += 1;
				ny += 1;
			}

//			print(board);
//			System.out.println();
		}
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j]==0) {
					answer++;
				}
			}
		}
		return answer;
	}

	private static void print(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	static class Bishop {
		int x;
		int y;

		Bishop(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
