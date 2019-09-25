import java.util.ArrayList;
import java.util.Collections;

public class programmers_divisor {

	public static void main(String[] args) {
		int[] arr = { 5, 9, 7, 10 };
		int divisor = 5;

		int[] ans = solution(arr, divisor);
		
		print(ans);
	}

	private static void print(int[] ans) {
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i]+" ");
		}
	}

	public static int[] solution(int[] arr, int divisor) {
		int[] answer = {};

		ArrayList<Integer> temp = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0) {
				temp.add(arr[i]);
			}
		}
		
		if( temp.size() > 0 ) {
			Collections.sort(temp);
			
			int n = temp.size();
			answer = new int[n];
			
			for (int i = 0; i < temp.size(); i++) {
				answer[i] = temp.get(i);
			}
		}else {
			answer = new int[1];
			answer[0] = -1;
		}
		return answer;
	}
}
