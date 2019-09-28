package boj;

import java.util.Arrays;

public class programmers_goods {
	public static void main(String[] args) {
		int[] goods = { 3, 8, 6 };
		int[] boxes = { 5, 6, 4 };

		int max = solution(goods, boxes);

		System.out.println(max);
	}

	public static int solution(int[] goods, int[] boxes) {
		int answer = 0;
		
		Arrays.sort(goods);
		Arrays.sort(boxes);
		
		boolean[] isChecked = new boolean[boxes.length];
		
		for (int i = 0; i < goods.length; i++) {
			for (int j = 0; j < boxes.length; j++) {
				if(goods[i] <= boxes[j] && !isChecked[j]) {
					answer++;
					isChecked[j] = true;
					break;
				}
			}
		}

		return answer;
	}
}
