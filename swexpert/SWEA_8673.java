package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_8673{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int t_case = 1; t_case <= t; t_case++) {
			int n = Integer.parseInt(br.readLine());

			String str = br.readLine();
			String[] numbers = str.split(" ");

			Queue<Integer> queue = new LinkedList<Integer>();

			for (int i = 0; i < numbers.length; i++) {
				queue.add(Integer.parseInt(numbers[i]));
			}

			int boring_score = 0;
			while (true) {
				if (queue.size() == 1) {
					break;
				}

				int player1 = queue.poll();
				int player2 = queue.poll();

				boring_score += Math.abs(player1 - player2);

				if (player1 > player2) {
					queue.add(player1);
				} else {
					queue.add(player2);
				}
			}
			
			System.out.println("#"+t_case+" "+boring_score);
		}
	}
}