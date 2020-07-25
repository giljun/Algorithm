import java.util.Stack;

public class kakao_crain {

	public static int solution(int[][] board, int[] moves) {
		int answer = 0;

		// 1. 크레인이 지정된 위치로 이동한다.
		Stack<Integer> basket = new Stack<>();
		for (int i = 0; i < moves.length; i++) {
			int curr = moves[i]-1;
			int doll = 0; // 0이면, 크레인에 잡혀 있는 인형이 없다는걸 의미한다.

			for (int j = 0; j < board.length; j++) {
				// 2. 크레인 작동 중, 인형이 있다면, 인형을 잡는다.
				if (board[j][curr] != 0) {
					doll = board[j][curr];
					board[j][curr] = 0;
					break;
				}
			}

			// 3. 잡은 인형을 바구니에 담아준다.
			if (doll != 0) {
				if (!basket.isEmpty()) {
					// 4. 바구니가 비어있지 않다면, 맨 위의 값과 비교하여 같은 값이면, 없애준다.
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
