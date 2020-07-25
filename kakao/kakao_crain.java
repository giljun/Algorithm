import java.util.Stack;

public class kakao_crain {

	public static int solution(int[][] board, int[] moves) {
		int answer = 0;

		// 1. ũ������ ������ ��ġ�� �̵��Ѵ�.
		Stack<Integer> basket = new Stack<>();
		for (int i = 0; i < moves.length; i++) {
			int curr = moves[i]-1;
			int doll = 0; // 0�̸�, ũ���ο� ���� �ִ� ������ ���ٴ°� �ǹ��Ѵ�.

			for (int j = 0; j < board.length; j++) {
				// 2. ũ���� �۵� ��, ������ �ִٸ�, ������ ��´�.
				if (board[j][curr] != 0) {
					doll = board[j][curr];
					board[j][curr] = 0;
					break;
				}
			}

			// 3. ���� ������ �ٱ��Ͽ� ����ش�.
			if (doll != 0) {
				if (!basket.isEmpty()) {
					// 4. �ٱ��ϰ� ������� �ʴٸ�, �� ���� ���� ���Ͽ� ���� ���̸�, �����ش�.
					if (basket.peek() == doll) {
						basket.pop();
						answer += 2;
					} else {
						basket.push(doll);
					}
				} else {
					basket.push(doll);
				}
			}
		}
		return answer;
	}

	private static void print(int[][] board, int[] moves) {
		for (int i = 0; i < moves.length; i++) {
			System.out.print(moves[i]);
		}

		System.out.println();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };

		int doll = solution(board, moves);
		
		System.out.println(doll);
	}
}
